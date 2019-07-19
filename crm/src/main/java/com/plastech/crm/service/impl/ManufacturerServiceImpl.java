package com.plastech.crm.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;
import com.plastech.crm.model.Manufacturer;
import com.plastech.crm.model.vo.ManufacturerView;
import com.plastech.crm.resultcode.ResultCodeManufacturer;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.service.ManufacturerService;
import com.plastech.crm.util.AppPage;
import com.plastech.crmcommon.page.AppPageModel;

/**
 * @author 王进
 *
 */
@Service
public class ManufacturerServiceImpl extends BaseService
    implements ManufacturerService {

  @Override
  public AppPageModel<List<ManufacturerView>> searchManufacturer(
      final Integer currentpage, final Integer perpage,
      final String searchKey) {
    final AppPage<List<ManufacturerView>> page =
        new AppPage<>(perpage, currentpage);
    page.start();

    String searchkey = null;
    if (!Strings.isNullOrEmpty(searchKey)) {
      searchkey = "%" + searchKey + "%";
    }

    final List<ManufacturerView> manufacturerList =
        manufacturerMapper.searchManufacturer(searchkey);
    page.setResult(manufacturerList);
    return page.convertToAppPageModel();
  }

  @Override
  public ResultJson<Integer> createManufacturer(final Long uId,
      final String name) {
    try {
      // 查询生产商名称是否存在
      final String checkName = manufacturerMapper.selectManufacturerName(name);
      if (!Strings.isNullOrEmpty(checkName)) {
        return ResultUtil.getResult(ResultCodeManufacturer.RESULT_CODE_4001300);
      }
      addOrUpdateManufacturer(null, uId, name);
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, 0,
          ResultCodeSystem.ADD_SUCCESS);
    } catch (final Exception e) {
      logger.info("add Exception:{}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, -1,
        ResultCodeSystem.ADD_FAIL);
  }

  private void addOrUpdateManufacturer(final Long mfId, final Long uId,
      final String name) {
    final Manufacturer manu = new Manufacturer();
    if (mfId == null) {
      manu.setCreatorTime(new Date());
      manu.setCreatorId(1L);
    }
    manu.setStatus(0);
    manu.setName(name);
    manu.setLastUpdateId(1L);
    manu.setLastUpdateTime(new Date());
    if (mfId == null) {
      manufacturerMapper.insertSelective(manu);
    } else {
      manu.setMfid(mfId);
      manufacturerMapper.updateByPrimaryKeySelective(manu);
    }
  }

  @Override
  public ResultJson<Integer> deleteManufacturer(final Long mfId) {
    try {
      // 查询生产商是否存在
      final Manufacturer manufacturer =
          manufacturerMapper.selectByPrimaryKey(mfId);
      if (manufacturer == null) {
        return ResultUtil.getResult(ResultCodeManufacturer.RESULT_CODE_4003300);
      }
      // 检查该生产商与牌号是否有关系
      final Boolean isPresence = gradeMapper.checkManufacturerByMfId(mfId);
      if (isPresence) {
        return ResultUtil.getResult(ResultCodeManufacturer.RESULT_CODE_4003301);
      }
      manufacturer.setStatus(-1);
      manufacturerMapper.updateByPrimaryKey(manufacturer);
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, 0,
          ResultCodeSystem.DELETE_SUCCESS);
    } catch (final Exception e) {
      logger.info("delete exception:{}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, -1,
        ResultCodeSystem.DELETE_FAIL);
  }

  @Override
  public ResultJson<Integer> updateManufacturer(final Long mfId, final Long uId,
      final String name) {
    try {
      // 查询生产商名称是否存在
      final String checkName = manufacturerMapper.selectManufacturerName(name);

      final Manufacturer manufacturerInfo =
          manufacturerMapper.selectByPrimaryKey(mfId);
      if (manufacturerInfo == null) {
        return ResultUtil.getResult(ResultCodeManufacturer.RESULT_CODE_4002301);
      }
      if (checkName != null) {
        if (!manufacturerInfo.getName().equals(checkName)) {
          return ResultUtil
              .getResult(ResultCodeManufacturer.RESULT_CODE_4002300);
        }
      }
      addOrUpdateManufacturer(mfId, uId, name);
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, 0,
          ResultCodeSystem.SAVE_SUCCESS);
    } catch (final Exception e) {
      logger.info("update exception:{}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, -1,
        ResultCodeSystem.SAVE_FAIL);
  }

  @Override
  public List<ManufacturerView> getManufacturerChooseList() {
    return manufacturerMapper.getManufacturerChooseList();

  }


}
