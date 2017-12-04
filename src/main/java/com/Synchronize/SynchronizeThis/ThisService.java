package com.Synchronize.SynchronizeThis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 添加this测试
 * Created by Think on 2017/10/25.
 */
public class ThisService {
    private static Logger logger = LoggerFactory.getLogger(ThisService.class);

    /**
     * 同步
     */
    public void serviceMethodA() {
        try {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " MethodA begin time = " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " MethodA end   time = " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            logger.info(e.toString());
        }
    }

    /**
     * 非同步
     */
    public void serviceMethodB() {
        System.out.println(Thread.currentThread().getName() + " MethodB begin time = " + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName() + " MethodB end   time = " + System.currentTimeMillis());
    }

}
