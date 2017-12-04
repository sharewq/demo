package com.Synchronize.SynchronizeStatic;

/**
 * 线程B
 * Created by Think on 2017/10/25.
 */
public class ThreadB extends Thread {
    @Override
    public void run() {
        ObjectService.methodB();
    }
}
