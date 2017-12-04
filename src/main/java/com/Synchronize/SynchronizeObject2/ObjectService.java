package com.Synchronize.SynchronizeObject2;

/**
 * Created by Think on 2017/10/30.
 */
public class ObjectService {
    private String lock = new String();

    public void methodA() {
        try {
            synchronized (lock) {
                System.out.println("Thread = " + Thread.currentThread().getName() + " begin");
                Thread.sleep(3000);
                System.out.println("Thread = " + Thread.currentThread().getName() + " end");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void methodB() {
        System.out.println("Thread = " + Thread.currentThread().getName() + " begin");
        System.out.println("Thread = " + Thread.currentThread().getName() + " end");
    }

}
