package com.Synchronize.SynchronizeStatic2;

/**
 * 添加this测试
 * Created by Think on 2017/10/25.
 */
public class ObjectService {
    public void methodA(){
        try {
            synchronized (ObjectService.class) {
                System.out.println("methodA begin 线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
                Thread.sleep(3000);
                System.out.println("methodA end   线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void methodB(){
        synchronized (ObjectService.class) {
            System.out.println("methodB begin 线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
            System.out.println("methodB end   线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
        }
    }

}
