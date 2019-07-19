package com.plastech.crm.service.impl;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.plastech.crm.mapper.CommodityMapper;
import com.plastech.crm.mapper.ContractGradeMapper;
import com.plastech.crm.mapper.ContractMapper;
import com.plastech.crm.mapper.ContractPurchaseMapper;
import com.plastech.crm.mapper.CustomerLoyaltyMapper;
import com.plastech.crm.mapper.CustomerMapper;
import com.plastech.crm.mapper.GradeMapper;
import com.plastech.crm.mapper.GroupsMapper;
import com.plastech.crm.mapper.ImportRawdataDetailMapper;
import com.plastech.crm.mapper.ImportRawdataMapper;
import com.plastech.crm.mapper.LinkmanMapper;
import com.plastech.crm.mapper.LoyaltyMapper;
import com.plastech.crm.mapper.ManufacturerMapper;
import com.plastech.crm.mapper.MenuMapper;
import com.plastech.crm.mapper.MiddleCustomerLinkmanMapper;
import com.plastech.crm.mapper.MiddleSupplierLinkmanMapper;
import com.plastech.crm.mapper.PermissionMapper;
import com.plastech.crm.mapper.RoleMapper;
import com.plastech.crm.mapper.RolePermissionMapper;
import com.plastech.crm.mapper.SaCommodityAnalysisMapper;
import com.plastech.crm.mapper.SaCommodityDetailMapper;
import com.plastech.crm.mapper.SaCommodityPurchaseMapper;
import com.plastech.crm.mapper.SaCustomerDetailAnalysisMapper;
import com.plastech.crm.mapper.SaGroupsAnalysisMapper;
import com.plastech.crm.mapper.SaManufacturerAnalysisMapper;
import com.plastech.crm.mapper.SaManufacturerDetailMapper;
import com.plastech.crm.mapper.SaManufacturerStMapper;
import com.plastech.crm.mapper.SaSalesManagerMapper;
import com.plastech.crm.mapper.SaSalesStMapper;
import com.plastech.crm.mapper.SupplierMapper;
import com.plastech.crm.mapper.UserMapper;

/**
 *
 *
 * @author : yemin
 *
 * @date : 2019年1月9日 下午6:24:28
 *
 */
@Service
public class BaseService {
  protected static final Logger logger =
      LoggerFactory.getLogger(BaseService.class);

  @Resource
  protected UserMapper userMapper;

  @Resource
  protected SupplierMapper supplierMapper;

  @Resource
  protected CommodityMapper commodityMapper;

  @Resource
  protected ManufacturerMapper manufacturerMapper;

  @Resource
  protected GradeMapper gradeMapper;

  @Resource
  protected GroupsMapper groupsMapper;

  @Resource
  protected PermissionMapper permissionMapper;

  @Resource
  protected RoleMapper roleMapper;

  @Resource
  protected RolePermissionMapper rolePermissionMapper;

  @Resource
  protected MenuMapper menuMapper;

  @Resource
  protected LoyaltyMapper loyaltyMapper;

  @Resource
  protected CustomerLoyaltyMapper customerLoyaltyMapper;

  @Resource
  protected CustomerMapper customerMapper;

  @Resource
  protected ImportRawdataMapper importRawdataMapper;

  @Resource
  protected ImportRawdataDetailMapper importRawdataDetailMapper;

  @Resource
  protected ContractMapper contractMapper;

  @Resource
  protected ContractGradeMapper contractGradeMapper;

  @Resource
  protected ContractPurchaseMapper contractPurchaseMapper;

  @Resource
  protected SaSalesStMapper saSalesStMapper;

  @Resource
  protected LinkmanMapper linkmanMapper;

  @Resource
  protected MiddleCustomerLinkmanMapper middleCustomerLinkmanMapper;

  @Resource
  protected MiddleSupplierLinkmanMapper middleSupplierLinkmanMapper;

  @Resource
  protected SaSalesManagerMapper saSalesManagerMapper;

  @Resource
  protected SaCommodityAnalysisMapper saCommodityAnalysisMapper;

  @Resource
  protected SaCommodityDetailMapper saCommodityDetailMapper;

  @Resource
  protected SaManufacturerAnalysisMapper saManufacturerMapper;

  @Resource
  protected SaManufacturerDetailMapper saManufacturerDetailMapper;

  @Resource
  protected SaManufacturerStMapper saManufacturerStMapper;

  @Resource
  protected SaGroupsAnalysisMapper saGroupsAnalysisMapper;

  @Resource
  protected SaCommodityPurchaseMapper saCommodityPurchaseMapper;

  @Resource
  protected SaCustomerDetailAnalysisMapper saCustomerDetailAnalysisMapper;

}
