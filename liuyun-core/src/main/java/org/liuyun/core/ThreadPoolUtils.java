package org.liuyun.core;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * 线程池工具类
 */
public class ThreadPoolUtils {

    public static final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(10);

}
