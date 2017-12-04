package com.Synchronize.SynchronizeStatic;

/**
 * 静态同步synchronized方法
 * Created by Think on 2017/10/25.
 */
public class MainStaticTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadA a = new ThreadA();
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB();
        b.setName("B");
        b.start();
    }

    /**
     结论：
     synchronized应用在static方法上，那是对当前对应的*.Class进行持锁。
     */
}
