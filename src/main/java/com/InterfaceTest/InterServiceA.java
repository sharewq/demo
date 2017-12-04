package com.InterfaceTest;

/**
 * Created by Think on 2017/11/23.
 */
public class InterServiceA implements inter {
    @Override
    public void hello() {
        System.out.println(" hello InterServiceA ");
    }

    @Override
    public void printHelllo() {
        System.out.println("printHelllo InterServiceA ");
    }
}
