package com.Concurrent;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.sun.istack.internal.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 异步高并发-异步异步
 * Created by Think on 2017/12/20.
 */
public class AsynConcurrent3 {
    private static Logger logger = LoggerFactory.getLogger(AsynConcurrent3.class);

    public static void main(String[] args) {

        List<ListenableFuture<String>> listenableFutures = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            int b = i;
            listenableFutures.add(ExecutorServiceUtils.getListeningExecutorService().submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return hello("a" + String.valueOf(b));
                }
            }));
        }


        //等待所有结果返回
        ListenableFuture<List<String>> listenableFutureResults = Futures.allAsList(listenableFutures);
        Futures.addCallback(listenableFutureResults, new FutureCallback<List<String>>() {

            @Override
            public void onSuccess(@Nullable List<String> list) {
                logger.info("onSuccess :");
                for (String str : list) {
                    world(str);
                }
            }

            public void onFailure(Throwable thrown) {
                logger.info("onFailure: thrown" + thrown);
            }
        }, ExecutorServiceUtils.getListeningExecutorService());

        try {
            listenableFutureResults.get(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.info("Exception " + e);
        }

    }

    public static String hello(String str) {
        logger.info("hello" + str);
        /*int a[] = {1, 2};
        logger.info(String.valueOf(a[3]));*/
        return str;
    }

    public static String world(String str) {
        logger.info(str);
        return "";
    }

}
