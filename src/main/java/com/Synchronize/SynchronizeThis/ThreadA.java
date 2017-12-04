package com.Synchronize.SynchronizeThis;

/**
 * 线程A
 * Created by Think on 2017/10/25.
 */
public class ThreadA extends Thread {

    private ThisService thisService;

    public ThreadA(ThisService thisService) {
        super();
        this.thisService = thisService;
    }

    @Override
    public void run() {
        super.run();
        thisService.serviceMethodA();
    }
}
