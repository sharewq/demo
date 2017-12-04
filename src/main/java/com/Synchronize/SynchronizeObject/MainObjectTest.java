package com.Synchronize.SynchronizeObject;

/**
 * 将任意对象作为对象监视器
 * Created by Think on 2017/10/30.
 */
public class MainObjectTest {
    public static void main(String[] args) {
        //1、
        ObjectService service=new ObjectService();
        ThreadA a=new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b=new ThreadB(service);
        b.setName("B");
        b.start();

        //2、下面我把String lock=new String();放在方法中会有啥结果了：
        //结论：
        //多个线程持有对象监视器作为同一个对象的前提下，同一时间只有一个线程可以执行synchronized(任意自定义对象)同步代码快。
    }

    /**
     *
     */
}
