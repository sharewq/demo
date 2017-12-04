package com.Synchronize.SynchronizeThis2;

/**
 * 验证synchronized (this)代码块是锁定当前对象
 * Created by Think on 2017/10/25.
 */
public class MainObjectTest {
    public static void main(String[] args) throws InterruptedException {
        ObjectService service = new ObjectService();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
        Thread.sleep(2000);
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
    }

    /**
     * 结论：
     上面三个小例子我们可以知道，多个线程调用同一个对象中的不同名称的synchronized同步方法或synchronized(this)同步代码块时，是同步的。
     1、synchronized同步方法
     ①对其它的synchronized同步方法或synchronized(this)同步代码块调用是堵塞状态；
     ②同一时间只有一个线程执行synchronized同步方法中的代码。
     2、synchronized(this)同步代码块
     ①对其它的synchronized同步方法或synchronized(this)同步代码块调用是堵塞状态；
     ②同一时间只有一个线程执行synchronized同步方法中的代码。
     */
}
