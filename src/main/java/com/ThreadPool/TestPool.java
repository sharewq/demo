package com.ThreadPool;

/**
 * 线程池测试
 * Created by Think on 2017/12/25.
 */
public class TestPool {
    public static void main(String[] args) {
        ThreadPool.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                /*执行任务*/
                System.out.println("dsds");
            }
        });
    }
}
