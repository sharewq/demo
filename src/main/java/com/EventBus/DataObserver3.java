package com.EventBus;

import com.google.common.eventbus.Subscribe;

/**
 * 观察者一
 * Created by Think on 2017/9/30.
 */
public class DataObserver3 {
    /**
     * 只有通过@Subscribe注解的方法才会被注册进EventBus
     * 而且方法有且只能有1个参数
     *
     * @param msg
     */
    @Subscribe
    public void func(String msg) {
        System.out.println("DataObserver3 : String msg: " + msg);
    }

    @Subscribe
    public void hand(Integer msg) {
        System.out.println("DataObserver3 : Integer msg: " + msg);
    }
}
