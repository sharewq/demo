package com.Synchronize.SynchronizeStatic2;

/**
 * synchronized(*.class)代码块
 * Created by Think on 2017/10/25.
 */
public class MainStaticTest {
    public static void main(String[] args) {
        ObjectService service = new ObjectService();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
    /**
     * 结论：
     同步synchronized(*.class)代码块的作用其实和synchronized static方法作用一样。Class锁对类的所有对象实例起作用。
     */
}
