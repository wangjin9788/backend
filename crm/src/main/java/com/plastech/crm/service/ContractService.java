package com.plastech.crm.service;

import java.util.List;
import java.util.Map;
import com.plastech.crm.exception.ContractException;
import com.plastech.crm.model.parameter.AddOrUpdateContractParameters;
import com.plastech.crm.model.vo.ContractBaseDetailView;
import com.plastech.crm.model.vo.ContractDetailView;
import com.plastech.crm.model.vo.ContractListView;
import com.plastech.crm.model.vo.ImportContractView;
import com.plastech.crm.model.vo.SalesManagerView;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crmcommon.page.AppPageModel;

/**
 * @author wangJin
 *
 * @date 2019年1月24日 上午10:43:51
 *
 */
public interface ContractService {
  AppPageModel<List<ContractListView>> searchContractList(
      Map<String, Object> map, Integer currentpage, Integer perpage);

  ResultJson<Long> addContract(AddOrUpdateContractParameters param, Long uid)
      throws ContractException;

  boolean isContractNumberNotExist(String contNo);

  ResultJson<Boolean> updateContract(Long coid,
      AddOrUpdateContractParameters param, Long uid) throws ContractException;

  List<SalesManagerView> getSalseManagersList();

  ContractDetailView expandingContractListByCgId(Long cgid);

  ContractBaseDetailView getContractBaseDetail(Long coid);

  ResultJson<Boolean> deleteContract(Long coid);

  AddOrUpdateContractParameters getContractInfoByCoid(final Long coid);

  ImportContractView isImportContractNumberNotExist(String contNo);

  Boolean getImportDetailStatus();

}
