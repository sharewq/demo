package com.Synchronize.SynchronizeStatic2;

/**
 * 线程B
 * Created by Think on 2017/10/25.
 */
public class ThreadB extends Thread {
    private ObjectService objectService;

    public ThreadB(ObjectService objectService) {
        super();
        this.objectService = objectService;
    }
    @Override
    public void run() {
        objectService.methodB();
    }
}
