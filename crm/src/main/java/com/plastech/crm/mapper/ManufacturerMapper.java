package com.plastech.crm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.Manufacturer;
import com.plastech.crm.model.vo.ManufacturerView;

public interface ManufacturerMapper extends BaseTkMapper<Manufacturer> {
  List<ManufacturerView> searchManufacturer(
      @Param(value = "searchKey") String searchKey);

  String selectManufacturerName(@Param(value = "name") String name);

  String selectManufacturerNameByMfid(@Param(value = "mfId") String mfId);

  Manufacturer selectByName(String manufacturerName);

  List<ManufacturerView> getManufacturerChooseList();

}
