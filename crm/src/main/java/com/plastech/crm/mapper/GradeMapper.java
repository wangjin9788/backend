package com.plastech.crm.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.Grade;
import com.plastech.crm.model.vo.ContractGradeListView;
import com.plastech.crm.model.vo.GradeView;

public interface GradeMapper extends BaseTkMapper<Grade> {

  List<GradeView> searchGradeList(Map<String, Object> map);

  Long checkGradePresence(@Param(value = "mfId") Long mfId,
      @Param(value = "ctId") Long ctId, @Param(value = "number") String number);

  Boolean checkCommodityByCtId(@Param(value = "ctId") Long ctId);

  Boolean checkManufacturerByMfId(@Param(value = "mfId") Long mfId);

  Grade selectByGradenumberAndMfidAndCtid(@Param("number") String gradeNumber,
      @Param("mfid") Long mfid, @Param("ctid") Long ctid);

  List<ContractGradeListView> getContractGradeList();

  List<Map<String,Object>> getContractRelationNumberByGeid(@Param("geid") Long geid);

  Grade getCtidAndMfidByGeid(@Param("geid") Long geid);

  Grade getImportGradeByCoid(@Param("coid") Long coid);
}
