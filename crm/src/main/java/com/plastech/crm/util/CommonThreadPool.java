package com.plastech.crm.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * common thread pool
 *
 * @author : yemin
 * @date : 2018年9月12日 下午5:27:24
 *
 */
public class CommonThreadPool {
  private CommonThreadPool() {}

  private static Logger logger =
      LoggerFactory.getLogger(CommonThreadPool.class);

  private static volatile ExecutorService fixedThreadPool = null;// 定长线程池
  private static volatile ExecutorService singleThreadPool = null;// 单线程化线程池，保证FIFO
  private static final int THREADPOOL_LENG = 4 * 2;// IO密集型，线程池大小一般设置为：CPU个数*2

  public static boolean addTaskToFixedQueue(final Runnable runnable) {
    try {
      if (fixedThreadPool == null) {
        synchronized (CommonThreadPool.class) {
          if (fixedThreadPool == null) {
            fixedThreadPool = Executors.newFixedThreadPool(THREADPOOL_LENG);// 定长线程池
          }
        }
      }
      fixedThreadPool.execute(runnable);
      return true;
    } catch (final Exception e) {
      logger.error("Fixed Thread Pool Error ", e);
    }
    return false;
  }

  public static boolean addTaskToSingleQueue(final Runnable runnable) {
    try {
      if (singleThreadPool == null) {
        synchronized (CommonThreadPool.class) {
          if (singleThreadPool == null) {
            singleThreadPool = Executors.newSingleThreadExecutor();// 单线程化线程池，保证FIFO
          }
        }
      }
      singleThreadPool.execute(runnable);
      return true;
    } catch (final Exception e) {
      logger.error("Single Thread Pool Error ", e);
    }
    return false;
  }
}
