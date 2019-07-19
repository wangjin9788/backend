package com.plastech.crm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.plastech.crm.config.ConfigUtil;
import com.plastech.crm.model.Customer;
import com.plastech.crm.model.Groups;
import com.plastech.crm.model.Linkman;
import com.plastech.crm.model.MiddleCustomerLinkman;
import com.plastech.crm.model.MiddleSupplierLinkman;
import com.plastech.crm.model.Supplier;
import com.plastech.crm.model.parameter.AddOrUpdateLinkmanParameter;
import com.plastech.crm.model.parameter.AddOrUpdateSupplierParameters;
import com.plastech.crm.model.vo.SupplierBaseDetailView;
import com.plastech.crm.model.vo.SupplierView;
import com.plastech.crm.service.SupplierService;
import com.plastech.crm.util.AppPage;
import com.plastech.crm.util.InitGroupAndManufacturerExcelTools;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月10日 下午5:55:29
 *
 */
@Service
public class SupplierServiceImpl extends BaseService
    implements SupplierService {

  @Override
  public AppPage<List<SupplierView>> searchSupplierList(
      final Map<String, String> param, final Integer currentpage,
      final Integer perpage) {
    final AppPage<List<SupplierView>> page =
        new AppPage<>(perpage, currentpage);
    page.start();
    final List<SupplierView> list = supplierMapper.searchSupplierList(param);
    page.setResult(list);
    return page;
  }

  @Override
  public int addOrUpdateSupplier(final AddOrUpdateSupplierParameters param,
      final Long uid, final Long suid) {
    try {

      if (suid == null || suid <= 0) {// 新建
        final Supplier esSupplier =
            supplierMapper.selectSuname(param.getSuName());
        if (esSupplier != null) {
          return 1;
        }
        final Supplier supplier = new Supplier();
        supplier.setCreatorId(uid);
        supplier.setCreatorTime(new Date());
        supplier.setLastUpdateId(uid);
        supplier.setLastUpdateTime(new Date());
        supplier.setNote(param.getNote());
        supplier.setStatus(0);
        supplier.setSuAddress(param.getSuAddress());
        supplier.setSuName(param.getSuName());
        supplier.setFullName(param.getFullName());
        supplierMapper.insert(supplier);
        if (param.getLinkmanList() != null) {
          // 添加联系人
          addOrUpdateLinkman(uid, supplier.getSuid(), param.getLinkmanList());
        }
      } else {// 更新
        final Supplier currentSupplier =
            supplierMapper.selectByPrimaryKey(suid);
        if (currentSupplier == null) {
          logger.error("Not exists supplier : suid = " + suid);
          return 2;
        }
        if (!param.getSuName().equals(currentSupplier.getSuName())) {// 供应商名称有变化
          final Supplier esSupplier =
              supplierMapper.selectSuname(param.getSuName());
          if (esSupplier != null) {
            return 1;
          }
        }
        currentSupplier.setLastUpdateId(uid);
        currentSupplier.setLastUpdateTime(new Date());
        currentSupplier.setNote(param.getNote());
        currentSupplier.setStatus(0);
        currentSupplier.setSuAddress(param.getSuAddress());
        currentSupplier.setSuName(param.getSuName());
        currentSupplier.setFullName(param.getFullName());
        supplierMapper.updateByPrimaryKey(currentSupplier);
        // 删除关联数据
        middleSupplierLinkmanMapper.deleteSupplierLinkmanByCuid(suid);
        if (param.getLinkmanList() != null) {
          // 编辑联系人
          addOrUpdateLinkman(uid, suid, param.getLinkmanList());
        }
      }

      return 0;
    } catch (final Exception e) {
      logger.error("Add or update supplier error , {}", e);
    }
    return -1;
  }

  @Override
  public int deleteSupplier(final Long suid) {
    try {
      final Supplier currentSupplier = supplierMapper.selectByPrimaryKey(suid);
      if (currentSupplier == null) {
        logger.error("Not exists supplier : suid = " + suid);
        return 1;
      }
      currentSupplier.setStatus(-1);
      final int count = supplierMapper.updateByPrimaryKey(currentSupplier);
      // 删除关联数据
      middleSupplierLinkmanMapper.deleteSupplierLinkmanByCuid(suid);
      if (count > 0) {
        return 0;
      }
    } catch (final Exception e) {
      logger.error("Delete supplier error , {}", e);
    }
    return -1;
  }

  private void addOrUpdateLinkman(final Long uid, final Long suid,
      final List<AddOrUpdateLinkmanParameter> LinkmanList) {
    for (final AddOrUpdateLinkmanParameter param : LinkmanList) {
      final Linkman linkman = new Linkman();
      linkman.setName(param.getName());
      linkman.setLkPosition(param.getLkPosition());
      linkman.setLkArea(param.getLkArea());
      linkman.setLkPhone(param.getLkPhone());
      linkman.setLkMail(param.getLkMail());
      linkman.setLkTags(param.getLkTags());
      linkman.setNote(param.getNote());
      linkman.setLastUpdateId(uid);
      linkman.setLastUpdateTime(new Date());
      linkman.setStatus(0);
      linkman.setCreatorId(uid);
      linkman.setCreatorTime(new Date());
      linkmanMapper.insertSelective(linkman);
      if (linkman != null || linkman.getLkid().longValue() > 0) {
        createMiddleSupplierLinkman(linkman.getLkid(), suid, uid);
      }
    }
  }

  private void createMiddleSupplierLinkman(final Long lkid, final Long suid,
      final Long uid) {
    final MiddleSupplierLinkman supplierLinkman = new MiddleSupplierLinkman();
    supplierLinkman.setSuid(suid);
    supplierLinkman.setLkid(lkid);
    supplierLinkman.setCreatorTime(new Date());
    middleSupplierLinkmanMapper.insertSelective(supplierLinkman);
  }

  @Override
  public SupplierBaseDetailView getSupplierBaseDetail(final Long suid) {
    return supplierMapper.getSupplierBaseDetail(suid);
  }

  @Override
  public Boolean initSupplier() {

    try {
      final List<String[]> readExcelByPoi =
          InitGroupAndManufacturerExcelTools.readExcelByPoi(
              ConfigUtil.getIntTempFolderPath() + "/init_supplier.xlsx", 0, 9, 1);

      for (final String[] info : readExcelByPoi) { // 查询供应商信息赋值重复创建同一家公司
        Supplier su = supplierMapper.checkInitSupplierInfo(trim(info[0]),
            trim(info[1]), trim(info[2]));
        if (su == null) {
          su = new Supplier();
          su.setStatus(0);
          su.setSuName(trim(info[0]));
          su.setFullName(trim(info[1]));
          su.setSuAddress(trim(info[2]));
          su.setCreatorId(1L);
          su.setCreatorTime(new Date());
          su.setNote("import");
          supplierMapper.insertSelective(su);
        }
        final Linkman link = new Linkman();
        link.setStatus(0);
        link.setName(trim(info[3]));
        link.setLkPosition(trim(info[4]));
        link.setLkArea("+852");
        link.setLkPhone(trim(info[5]));
        link.setLkMail(trim(info[6]));
        link.setLkTags(trim(info[7]));
        link.setNote(trim(info[8]));
        linkmanMapper.insertSelective(link);
        if (link.getLkid() != null && link.getLkid().longValue() > 0
            && su.getSuid() != null && su.getSuid().longValue() > 0) {
          final MiddleSupplierLinkman sl = new MiddleSupplierLinkman();
          sl.setLkid(link.getLkid());
          sl.setSuid(su.getSuid());
          sl.setCreatorTime(new Date());
          middleSupplierLinkmanMapper.insertSelective(sl);
        }
      }

      return initGroups();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  // 初始化用户
  private boolean initGroups() {
    try {
      final List<String[]> groupList =
          InitGroupAndManufacturerExcelTools.readExcelByPoi(
              ConfigUtil.getIntTempFolderPath() + "/init_groups.xlsx", 0, 9, 2);
      for (final String[] info : groupList) {
        Groups group = groupsMapper.selectByNameAndType(trim(info[0]), 1);
        if (group == null) {
          group = new Groups();
          group.setCode(0);
          group.setType(1);
          group.setCreatorId(1L);
          group.setCreatorTime(new Date());
          group.setName(trim(info[0]));
          group.setStatus(0);
          group.setNote("import");
          groupsMapper.insertSelective(group);
        }
        Customer customer = customerMapper.checkInitCustomerInfo(group.getGid(),
            trim(info[1]), trim(info[2]));
        if (customer == null) {
          customer = new Customer();
          customer.setCreatorId(1L);
          customer.setCreatorTime(new Date());
          customer.setStatus(0);
          customer.setGid(group.getGid());
          customer.setCuName(trim(info[1]));
          customer.setCuAddress(trim(info[2]));
          customerMapper.insertSelective(customer);
        }
        final Linkman link = new Linkman();
        link.setStatus(0);
        link.setName(trim(info[3]));
        link.setLkPosition(trim(info[4]));
        link.setLkArea("+852");
        link.setLkPhone(trim(info[5]));
        link.setLkMail(trim(info[6]));
        link.setLkTags(trim(info[7]));
        link.setNote(trim(info[8]));
        linkmanMapper.insertSelective(link);
        if (customer.getCuid() != null && customer.getCuid().longValue() > 0
            && link.getLkid() != null && link.getLkid().longValue() > 0) {
          final MiddleCustomerLinkman mcl = new MiddleCustomerLinkman();
          mcl.setCuid(customer.getCuid());
          mcl.setLkid(link.getLkid());
          mcl.setCreatorTime(new Date());
          middleCustomerLinkmanMapper.insert(mcl);
        }
      }
      return true;
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  private static String trim(final String str) {
    return str != null ? str.trim() : str;
  }

  @Override
  public List<SupplierView> suppliersContractList() {
    return supplierMapper.getSuppliersContractList();
  }
}
