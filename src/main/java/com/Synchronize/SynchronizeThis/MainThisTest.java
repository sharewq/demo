package com.Synchronize.SynchronizeThis;


/**
 * synchronized代码块间的同步性
 * Created by Think on 2017/10/25.
 */
public class MainThisTest {
    public static void main(String[] args) {
        ThisService service = new ThisService();
        ThreadA a = new ThreadA(service);
        a.setName("a");
        a.start();

        ThreadA c = new ThreadA(service);
        c.setName("c");
        c.start();

        ThreadB b = new ThreadB(service);
        b.setName("b");
        b.start();

        ThreadB d = new ThreadB(service);
        d.setName("d");
        d.start();

        //结论：
        //当一个线程访问ObjectService的一个synchronized (this)同步代码块时，
        //其它线程对同一个ObjectService中其它的synchronized (this)同步代码块的访问将是堵塞，这说明synchronized (this)使用的对象监视器是一个。
    }
}
