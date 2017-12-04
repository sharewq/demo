package Junit.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解
 * Created by Think on 2017/11/29.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String hello() default "gege";

    String world();

    int[] array() default {2, 4, 5, 6};

    //EnumTest.TrafficLamp lamp();

    //TestAnnotation lannotation() default @TestAnnotation(value = "ddd");

    Class style() default String.class;
}
