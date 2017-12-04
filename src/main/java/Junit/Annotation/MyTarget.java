package Junit.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 用@Retention(RetentionPolicy.RUNTIME )修饰的注解，
 * 表示注解的信息被保留在class文件(字节码文件)中当程序编译时，会被虚拟机保留在运行时
 * Created by Think on 2017/11/29.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTarget {
}
