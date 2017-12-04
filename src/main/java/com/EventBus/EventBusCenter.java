package com.EventBus;

import com.google.common.eventbus.EventBus;

/**
 * Created by Think on 2017/9/30.
 */
public class EventBusCenter {

    private static EventBus eventBus = new EventBus();

    private EventBusCenter() {

    }

    public static EventBus getInstance() {
        return eventBus;
    }

    /**
     * 寄存器
     *
     * @param obj
     */
    public static void register(Object obj) {
        eventBus.register(obj);
    }

    /**
     * 注销
     *
     * @param obj
     */
    public static void unregister(Object obj) {
        eventBus.unregister(obj);
    }

    public static void post(Object obj) {
        eventBus.post(obj);
    }

}
