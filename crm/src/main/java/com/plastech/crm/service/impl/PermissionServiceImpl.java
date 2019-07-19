package com.plastech.crm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;
import com.plastech.crm.model.RolePermission;
import com.plastech.crm.model.vo.Authority;
import com.plastech.crm.model.vo.ModuleMenuPermissionView;
import com.plastech.crm.model.vo.ModuleMenuView;
import com.plastech.crm.model.vo.ModuleView;
import com.plastech.crm.model.vo.RolePermissionView;
import com.plastech.crm.model.vo.RoleView;
import com.plastech.crm.service.PermissionService;
import com.plastech.crm.util.CommonThreadPool;
import com.plastech.crm.util.constant.Constant;
import com.plastech.crm.util.thread.PermissionReloadThread;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月21日 下午3:35:27
 *
 */
@Service
public class PermissionServiceImpl extends BaseService
    implements PermissionService {

  @Autowired
  @Lazy // 防止循环依赖
  private ShiroFilterFactoryBean shiroFilterFactoryBean;

  @Override
  public Map<String, String> loadFilterChainDefinitions() {
    // 从DB中读取权限数据
    final List<Authority> authorities =
        rolePermissionMapper.getAllAuthorities();
    final Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

    // login不做认证，noSessionCreation的作用是用户在操作session时会抛异常
    filterChainDefinitionMap.put("/user-management/users/logout",
        "noSessionCreation,authcToken[permissive]");

    // 测试
    // filterChainDefinitionMap.put(
    // "^/permission-management/filter-chains/reload[0-9]+$==GET", // 必须大写
    // "noSessionCreation,authcToken[permissive]");

    if (authorities != null && authorities.size() > 0) {
      for (final Authority authority : authorities) {
        final String uri = getFullUri(authority);// 包含=get的uri
        final String authcTokenSet = getAuthcTokenSet(authority);
        final String roleSet = getRoleSet(authority, authcTokenSet);
        filterChainDefinitionMap.put(uri,
            "noSessionCreation" + authcTokenSet + roleSet);
        logger.info("Add Web chain --> " + uri + ":" + "noSessionCreation"
            + authcTokenSet + roleSet);
      }
    }

    // 登陆不能做权限校验，因为在进入接口之前还没有token，不方便拿用户信息
    filterChainDefinitionMap.put(Constant.LOGIN_URL, "noSessionCreation,anon");

    // 默认
    filterChainDefinitionMap.put("/**",
        "noSessionCreation,authcToken[permissive]");
    return filterChainDefinitionMap;
  }

  private String getRoleSet(final Authority authority,
      final String authcTokenSet) {
    return "";

    // if (",anon".equals(authcTokenSet)) {
    // return "";
    // }
    // final String roles = authority.getRoles();
    // if (!Strings.isNullOrEmpty(roles)) {
    // return ",anyRole[" + roles + "]";
    // } else {
    // return "";
    // }
  }

  private String getAuthcTokenSet(final Authority authority) {
    final Integer tokenPermissive = authority.getTokenPermissive();
    if (tokenPermissive == 1) {// 校验token但允许校验不通过
      return ",authcToken[permissive]";
    } else if (tokenPermissive == 0) {// 校验token且必须校验通过
      return ",authcToken";
    } else {// 不会校验token
      return ",anon";
    }
  }

  private String getFullUri(final Authority authority) {
    String method = authority.getMethod();
    if (!Strings.isNullOrEmpty(method)) {
      method = method.toUpperCase();
      if ("GET".equals(method) || "POST".equals(method) || "PUT".equals(method)
          || "DELETE".equals(method) || "PATCH".equals(method)) {
        return authority.getUri() + "==" + method;
      }
    }
    return authority.getUri();
  }

  @Override
  public boolean reloadFilterChain() {
    synchronized (this) {
      AbstractShiroFilter shiroFilter;
      try {
        shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
      } catch (final Exception e) {
        logger.error("Get ShiroFilter from shiroFilterFactoryBean error!", e);
        return false;
      }

      if (shiroFilter == null) {
        return false;
      }
      final PathMatchingFilterChainResolver filterChainResolver =
          (PathMatchingFilterChainResolver) shiroFilter
              .getFilterChainResolver();
      final DefaultFilterChainManager manager =
          (DefaultFilterChainManager) filterChainResolver
              .getFilterChainManager();
      // 清空旧的权限数据
      manager.getFilterChains().clear();

      // 重新读取权限数据
      shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
      shiroFilterFactoryBean
          .setFilterChainDefinitionMap(loadFilterChainDefinitions());
      // 重新构建生成
      final Map<String, String> chains =
          shiroFilterFactoryBean.getFilterChainDefinitionMap();
      for (final Map.Entry<String, String> entry : chains.entrySet()) {
        final String url = entry.getKey();
        final String chainDefinition = entry.getValue().trim().replace(" ", "");
        manager.createChain(url, chainDefinition);
      }
      return true;
    }
  }

  @Override
  public boolean updatePermissionOfRole(final Long roleid,
      final List<Long> pmidList) {
    try {
      rolePermissionMapper.deleteByRoleid(roleid);
      if (pmidList != null && pmidList.size() > 0) {
        for (final Long pmid : pmidList) {
          if (pmid == null || pmid <= 0) {
            continue;
          }
          final RolePermission rolePermission = new RolePermission();
          rolePermission.setCreateTime(new Date());
          rolePermission.setNote("");
          rolePermission.setPmid(pmid);
          rolePermission.setRoleid(roleid);
          rolePermissionMapper.insertSelective(rolePermission);
        }
      }
      CommonThreadPool.addTaskToFixedQueue(new PermissionReloadThread(this));// 重新加载权限数据
      // new Thread(new PermissionReloadThread(this)).start();// 重新加载权限数据
      return true;
    } catch (final Exception e) {
      logger.info("Update permission error , {}", e);
    }
    return false;
  }

  @Override
  public List<RoleView> getAllRoles() {
    return roleMapper.getAllRoles();
  }

  @Override
  public RolePermissionView getModulePermissionViewByRoleid(final Long roleid) {
    final RolePermissionView rolePermissionView = new RolePermissionView();
    // 一条SQL查出所有permission
    final List<ModuleMenuPermissionView> perViewList =
        rolePermissionMapper.getPermissionViewByRoleid(roleid);

    // 逻辑处理
    final List<ModuleView> moduleViewList = new ArrayList<ModuleView>();// moduleViewList是按照先moduleCode后menuCode排序的
    if (perViewList != null && perViewList.size() > 0) {
      ModuleView currentModuleView = null;
      ModuleMenuView currentModuleMenuView = null;
      String currentModuleCode = null;
      String currentMenuCode = null;
      // boolean firstAdd = true;
      for (final ModuleMenuPermissionView perView : perViewList) {
        final String moduleCode = perView.getModuleCode();
        final String menuCode = perView.getMenuCode();
        if (!menuCode.equals(currentMenuCode)) {// menuCode发生变化，则表示进入了下一个menu
          if (currentModuleMenuView != null) {
            currentModuleView.addMenuList(currentModuleMenuView);
          }
          currentModuleMenuView = new ModuleMenuView();
          currentModuleMenuView.setMenuName(perView.getMenuName());
        }
        if (!moduleCode.equals(currentModuleCode)) {// moduleCode发生变化。则表示进入了下一个module
          if (currentModuleView != null) {
            moduleViewList.add(currentModuleView);
          }
          currentModuleView = new ModuleView();
          currentModuleView.setModuleName(perView.getModuleName());
        }
        currentModuleMenuView.addPerssion(perView);
        currentModuleCode = moduleCode;
        currentMenuCode = menuCode;
      }
      if (currentModuleView != null) {
        currentModuleView.addMenuList(currentModuleMenuView);
      }
      moduleViewList.add(currentModuleView);
    }

    rolePermissionView.setModuleViewList(moduleViewList);
    rolePermissionView.setPermissionList(perViewList);
    return rolePermissionView;
  }

}
