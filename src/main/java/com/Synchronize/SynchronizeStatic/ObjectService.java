package com.Synchronize.SynchronizeStatic;

/**
 * 添加this测试
 * Created by Think on 2017/10/25.
 */
public class ObjectService {
    public synchronized static void methodA() {
        try {
            System.out.println("static methodA begin 线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("static methodA end   线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void methodB() {
        System.out.println("static methodB begin 线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
        System.out.println("static methodB end   线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
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
