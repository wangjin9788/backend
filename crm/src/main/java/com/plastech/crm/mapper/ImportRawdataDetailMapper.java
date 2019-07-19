package com.plastech.crm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.ImportRawdataDetail;
import com.plastech.crm.model.vo.ImportRawdataExplainResultData;

public interface ImportRawdataDetailMapper
    extends BaseTkMapper<ImportRawdataDetail> {

  Long selectCountByIridAndType(@Param("irid") Long irid,
      @Param("type") int type);

  List<ImportRawdataExplainResultData> getExplainResultDataList(
      @Param("irid") Long irid, @Param("searchtype") Integer searchtype);

  List<ImportRawdataExplainResultData> getExplainResultDataListOfAddOrUpdate(
      Long irid);

  void updateNoteByIrid(@Param("irid") Long irid, @Param("note") String note);

  void updateImportDetailStatus(@Param("irdid") Long irdid,
      @Param("type") Integer type);

  Boolean getImportDetailStatus();
}
