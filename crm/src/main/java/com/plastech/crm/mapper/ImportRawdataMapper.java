package com.plastech.crm.mapper;

import java.util.List;
import java.util.Map;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.ImportRawdata;
import com.plastech.crm.model.vo.ImportRawdataInfo;

public interface ImportRawdataMapper extends BaseTkMapper<ImportRawdata> {

  ImportRawdata selectUnFinishedImportRecord();

  List<ImportRawdataInfo> searchImportRawdataList(
      Map<String, String> parameter);

}
