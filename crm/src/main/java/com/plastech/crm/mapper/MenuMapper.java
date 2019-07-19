package com.plastech.crm.mapper;

import java.util.List;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.Menu;
import com.plastech.crm.model.vo.MenuInfo;

public interface MenuMapper extends BaseTkMapper<Menu> {

  List<MenuInfo> getUserThirdLevelMenusByRoleidForShiro(Long roleid);

  List<MenuInfo> getAllFirstAndSecondLevelMenusForShiro();
}
