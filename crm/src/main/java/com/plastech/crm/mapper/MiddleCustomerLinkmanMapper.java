package com.plastech.crm.mapper;

import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.MiddleCustomerLinkman;

public interface MiddleCustomerLinkmanMapper
    extends BaseTkMapper<MiddleCustomerLinkman> {
 Integer deleteCustomerLinkmanInfoByCuid(Long cuid);
}
