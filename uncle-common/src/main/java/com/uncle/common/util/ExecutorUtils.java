package com.uncle.common.util;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.*;

/**
 *
 * @Desc: 线程工具类
 * @author: uncle
 * @date: 2018/10/12
 */
public class ExecutorUtils {

    private static Integer THREAD_COUNT = Runtime.getRuntime().availableProcessors() * 2 + 1; //线程池数

    private static Integer KEEP_ALIVE_TIME = 30;//保活时间

    private static LinkedBlockingQueue<Runnable> WORK_BLOCKING_QUEUE = new LinkedBlockingQueue<>();//无界队列
    // java executor
    public static ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(THREAD_COUNT, THREAD_COUNT, KEEP_ALIVE_TIME, TimeUnit.SECONDS, WORK_BLOCKING_QUEUE);
    //Guava executor
    public static ListeningExecutorService LISTENING_EXECUTOR_SERVICE = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(THREAD_COUNT));
}
