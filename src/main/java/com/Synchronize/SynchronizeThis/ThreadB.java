package com.Synchronize.SynchronizeThis;

/**
 * 线程B
 * Created by Think on 2017/10/25.
 */
public class ThreadB extends Thread {
    private ThisService thisService;

    public ThreadB(ThisService thisService) {
        super();
        this.thisService = thisService;
    }

    @Override
    public void run() {
        super.run();
        thisService.serviceMethodB();
    }
}
