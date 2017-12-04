package com.Test;

import java.io.File;

/**
 * Created by Think on 2017/11/29.
 */
public class test1 {
    public static void main(String[] args) {
        File file = new File("HelloWorld.java");
        String fileName = file.getName();
        System.out.println(fileName);
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        System.out.println(suffix);
    }
}
