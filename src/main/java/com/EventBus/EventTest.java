package com.EventBus;

/**
 * 代码测试
 * Created by Think on 2017/9/30.
 */
public class EventTest {
    public static void main(String[] args) throws InterruptedException {

        DataObserver1 observer1 = new DataObserver1();
        DataObserver2 observer2 = new DataObserver2();
        DataObserver3 observer3 = new DataObserver3();

        EventBusCenter.register(observer1);
        EventBusCenter.register(observer2);
        EventBusCenter.register(observer3);

        System.out.println("============   start  ====================");

        // 只有注册的参数类型为String的方法会被调用(注册类型位int的，会调用第二个)
        /**
         * 对于加入里面的方法区分是通过参数的不同类型来区分调用那个方法的。
         */
        EventBusCenter.post("post string method");
        EventBusCenter.post(123);

        System.out.println("============ after unregister ============");
        // 注销observer2
        EventBusCenter.unregister(observer2);
        EventBusCenter.post("post string method");
        EventBusCenter.post(123);

        System.out.println("============    end           =============");
    }
}
