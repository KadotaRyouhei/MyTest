package com.example.shanliang.mvvmtest;

import annotation.BindAddress;
import annotation.BindPort;

/**
 * Created by shanliang on 2018/3/12.
 */

public class AnnotationTest {
    @BindAddress()
    String address;

    @BindPort()
    private String port;

    private int number;

    public void printInfo() {
        System.out.println("info is" + address + ":" + port);
    }
}
