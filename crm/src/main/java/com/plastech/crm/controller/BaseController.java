package com.plastech.crm.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.plastech.crm.model.User;
import com.plastech.crm.service.CommodityService;
import com.plastech.crm.service.ContractService;
import com.plastech.crm.service.CustomerService;
import com.plastech.crm.service.ExportService;
import com.plastech.crm.service.GradeService;
import com.plastech.crm.service.GroupsService;
import com.plastech.crm.service.ImportService;
import com.plastech.crm.service.LoginService;
import com.plastech.crm.service.LoyaltyService;
import com.plastech.crm.service.ManufacturerService;
import com.plastech.crm.service.PermissionService;
import com.plastech.crm.service.SaCommodityAnalysisServer;
import com.plastech.crm.service.SaCommodityPurchaseService;
import com.plastech.crm.service.SaCustomerDetailAnalysisService;
import com.plastech.crm.service.SaGroupsAnalysisService;
import com.plastech.crm.service.SaManagerAnalysisService;
import com.plastech.crm.service.SaManufacturerAnalysisService;
import com.plastech.crm.service.SaSalesAnalysisService;
import com.plastech.crm.service.SupplierService;
import com.plastech.crm.service.UserService;
import com.plastech.crm.util.RequestParseUtil;


/**
 *
 *
 * @author : yemin
 * @date : 2019年1月10日 上午11:09:17
 *
 */
public class BaseController {

  protected static final Logger logger =
      LoggerFactory.getLogger(BaseController.class);

  @Autowired
  protected LoginService loginService;

  @Autowired
  protected UserService userService;

  @Autowired
  protected SupplierService supplierService;

  @Autowired
  protected CommodityService commodityService;

  @Autowired
  protected ManufacturerService manufacturerService;

  @Autowired
  protected GradeService gradeService;

  @Autowired
  protected GroupsService groupsService;

  @Autowired
  protected LoyaltyService loyaltyService;

  @Autowired
  protected CustomerService customerService;

  @Autowired
  protected PermissionService permissionService;

  @Autowired
  protected ImportService importService;

  @Autowired
  protected ContractService contractService;

  @Autowired
  protected SaSalesAnalysisService saSalesAnalysisService;

  @Autowired
  protected SaManagerAnalysisService saManagerAnalysisService;

  @Autowired
  protected SaCommodityAnalysisServer saCommodityAnalysisServer;

  @Autowired
  protected SaManufacturerAnalysisService saManufacturerAnalysisService;

  @Autowired
  protected SaSalesAnalysisService salesAnalysisService;

  @Autowired
  protected ExportService exportService;

  @Autowired
  protected SaGroupsAnalysisService saGroupsAnalysisService;

  @Autowired
  protected SaCommodityPurchaseService saCommodityPurchaseService;

  @Autowired
  protected SaCustomerDetailAnalysisService saCustomerDetailAnalysisService;

  protected User getCurrentUser(final HttpServletRequest request) {
    final Long uid = RequestParseUtil.getUid(request);
    User user = null;
    if (uid != null && uid > 0) {
      user = userService.getUserByUid(uid);
      if (user != null) {
        user.setPwd("");
        return user;
      }
    }
    user = new User();
    user.setUid(0L);
    user.setUname("");
    return user;
  }

  protected Long getCurrentUid(final HttpServletRequest request) {
    return RequestParseUtil.getUid(request);
  }

}
