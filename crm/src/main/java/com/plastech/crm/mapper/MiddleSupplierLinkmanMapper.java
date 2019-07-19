package com.plastech.crm.mapper;

import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.MiddleSupplierLinkman;

public interface MiddleSupplierLinkmanMapper extends BaseTkMapper<MiddleSupplierLinkman> {

  Integer deleteSupplierLinkmanByCuid(Long suid);
}