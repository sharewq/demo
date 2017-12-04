package com.Synchronize.SynchronizeStatic;

/**
 * 线程A
 * Created by Think on 2017/10/25.
 */
public class ThreadA extends Thread {
    @Override
    public void run() {
        ObjectService.methodA();
    }
}
