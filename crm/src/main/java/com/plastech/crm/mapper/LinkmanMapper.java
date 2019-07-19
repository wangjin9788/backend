package com.plastech.crm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.Linkman;
import com.plastech.crm.model.vo.LinkmanView;

public interface LinkmanMapper extends BaseTkMapper<Linkman> {

  List<LinkmanView> getSupplierLinkmanDetail(@Param(value = "suid") Long suid);

  List<LinkmanView> getCustomerLinkmanDetail(@Param(value = "suid") Long suid);

  Integer getSupplierLinkmanCountBySuid(@Param(value = "suid") Long suid);

  Integer getCustomerLinkmanCountByCuid(@Param(value = "cuid") Long cuid);
}
