package com.InterfaceTest;

/**
 * Created by Think on 2017/11/23.
 */
public class TestInter {
    public static void main(String[] args) {
        inter A = new InterServiceA();
        inter B = new InterServiceB();
        hello(A);
        hello(B);
    }

    public static void hello(inter in) {
        in.hello();
        in.printHelllo();
    }

}
