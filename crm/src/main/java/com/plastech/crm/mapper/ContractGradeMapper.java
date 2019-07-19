package com.plastech.crm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.ContractGrade;
import com.plastech.crm.model.parameter.AddOrUpdateContractGradeParameters;
import com.plastech.crm.model.vo.ContractGradeView;
import com.plastech.crm.model.vo.ContractGrossSalesView;

public interface ContractGradeMapper extends BaseTkMapper<ContractGrade> {

  List<ContractGradeView> selectContractGradeList(
      @Param(value = "coid") Long coid,
      @Param(value = "endShipmtDate") String endShipmtDate,
      @Param(value = "startShipmtDate") String startShipmtDate);

  ContractGrossSalesView getContractGrossSalesByCoid(
      @Param(value = "coid") Long coid);


  List<AddOrUpdateContractGradeParameters> getContractBaseDetailList(
      @Param(value = "coid") Long coid);

  Boolean checkContractGrade(@Param(value = "geid") Long geid);

  String selectEarliestContractGradeShipmt();

  String selectLatestContractGradeShipmt();

  ContractGrade selectAnyNormalData();

  List<ContractGrade> getImportContractGradeByCoidAndGeid(
      @Param(value = "coid") Long coid, @Param(value = "gNumber") String  gNumber);
}
