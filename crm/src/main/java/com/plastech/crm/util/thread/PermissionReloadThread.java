package com.plastech.crm.util.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.plastech.crm.service.PermissionService;

/**
 *
 *
 * @author : yemin
 * @date : 2018年12月29日 下午3:14:06
 *
 */
public class PermissionReloadThread implements Runnable {

  private static final Logger logger =
      LoggerFactory.getLogger(PermissionReloadThread.class);

  private final PermissionService permissionService;

  public PermissionReloadThread(final PermissionService permissionService) {
    super();
    this.permissionService = permissionService;
  }

  @Override
  public void run() {
    try {
      permissionService.reloadFilterChain();
    } catch (final Exception e) {
      logger.error("Reload filter chain Error : {}", e);
    }
  }

}
