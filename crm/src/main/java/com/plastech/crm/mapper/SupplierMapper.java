package com.plastech.crm.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.Supplier;
import com.plastech.crm.model.vo.ExportSupplierAndGroupsView;
import com.plastech.crm.model.vo.SupplierBaseDetailView;
import com.plastech.crm.model.vo.SupplierView;

public interface SupplierMapper extends BaseTkMapper<Supplier> {

  List<SupplierView> searchSupplierList(Map<String, String> param);

  Supplier selectSuname(@Param("suName") String suName);

  SupplierBaseDetailView getSupplierBaseDetail(
      @Param(value = "suid") Long suid);

  Supplier checkInitSupplierInfo(@Param(value = "name") String name,
      @Param(value = "fullName") String fullName,
      @Param(value = "address") String address);

  List<ExportSupplierAndGroupsView> getExportSupplierInfoList();

  List<SupplierView> getSuppliersContractList();

}
