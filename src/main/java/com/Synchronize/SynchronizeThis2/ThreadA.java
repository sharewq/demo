package com.Synchronize.SynchronizeThis2;

/**
 * 线程A
 * Created by Think on 2017/10/25.
 */
public class ThreadA extends Thread {
    private ObjectService objectService;

    public ThreadA(ObjectService objectService) {
        super();
        this.objectService = objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.objectMethodA();
    }
}
