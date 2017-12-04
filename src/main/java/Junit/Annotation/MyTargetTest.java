package Junit.Annotation;

import java.lang.reflect.Method;

/**
 * Created by Think on 2017/11/29.
 */
public class MyTargetTest {

    @MyTarget
    public void doSomething() {
        System.out.println("hello world");
    }

    public static void main(String[] args) throws Exception {
        Method method = MyTargetTest.class.getMethod("doSomething", null);
        //如果doSomething方法上存在注解@MyTarget，则为true
        if (method.isAnnotationPresent(MyTarget.class)) {
            System.out.println(method.getAnnotation(MyTarget.class));
        }
    }
}
