package com.plastech.crm.service;

import java.util.List;
import java.util.Map;
import com.plastech.crm.model.parameter.AddOrUpdateSupplierParameters;
import com.plastech.crm.model.vo.SupplierBaseDetailView;
import com.plastech.crm.model.vo.SupplierView;
import com.plastech.crm.util.AppPage;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月10日 下午5:50:32
 *
 */
public interface SupplierService {

  AppPage<List<SupplierView>> searchSupplierList(Map<String, String> param,
      Integer currentpage, Integer perpage);

  int addOrUpdateSupplier(AddOrUpdateSupplierParameters param, Long uid,
      Long suid);

  int deleteSupplier(Long suid);

  SupplierBaseDetailView getSupplierBaseDetail(Long suid);

  Boolean initSupplier();

  List<SupplierView> suppliersContractList();

}
