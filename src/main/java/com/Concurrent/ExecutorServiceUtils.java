package com.Concurrent;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.*;

/**
 * 线程池
 * Created by Think on 2017/12/20.
 */
public class ExecutorServiceUtils {

    private static ListeningExecutorService executorService = null;
    private static ListeningExecutorService executorService2 = null;
    private static ListeningExecutorService executorService3 = null;
    private static ScheduledExecutorService scheduledExecutorService = null;
    private static final long newFixedKeepAliveTimeOut = 30L;
    private static final long newFixedKeepAliveTimeOut2 = 60L;

    public ExecutorServiceUtils() {
    }

    public static synchronized ListeningExecutorService getListeningExecutorService() {
        if (executorService == null) {
            executorService = MoreExecutors.listeningDecorator(new ThreadPoolExecutor(30, 120, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue()));
        }

        return executorService;
    }

    public static synchronized ListeningExecutorService getListeningExecutorService3() {
        if (executorService3 == null) {
            executorService3 = MoreExecutors.listeningDecorator(new ThreadPoolExecutor(60, 240, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue()));
        }

        return executorService3;
    }

    public static synchronized ListeningExecutorService getListeningExecutorService2() {
        if (executorService2 == null) {
            executorService2 = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        }

        return executorService2;
    }

    public static synchronized ListeningExecutorService newListeningExecutorService() {
        return MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());
    }

    public static synchronized ScheduledExecutorService scheduledExecutorService() {
        if (scheduledExecutorService == null) {
            scheduledExecutorService = Executors.newScheduledThreadPool(120);
        }

        return scheduledExecutorService;
    }
}
