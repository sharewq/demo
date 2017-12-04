package com.Synchronize.SynchronizeThis2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 添加this测试
 * Created by Think on 2017/10/25.
 */
public class ObjectService {
    private static Logger logger = LoggerFactory.getLogger(ObjectService.class);

/*  第一次车上
 public void objectMethodA() {
        System.out.println(" synchronized thread name:" + Thread.currentThread().getName() + "--->objectMethodA");
    }*/

    public synchronized void objectMethodA() {
        System.out.println(" synchronized thread name:" + Thread.currentThread().getName() + "--->objectMethodA");
    }

    public void objectMethodB() {
        synchronized (this) {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(" synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
