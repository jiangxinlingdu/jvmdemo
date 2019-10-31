package com.lingdu.jvm;


import java.util.ArrayList;
import java.util.List;

public class XmsXmxDemo2 {
    private static final int _1MB = 1024 * 1024;


    /*
       -Xms20m
       -Xmx40m
       -Xmn10m
       -XX:+PrintGCDetails
       -XX:+PrintGCDateStamps
       -XX:+UseSerialGC
       */



    public static void main(String[] args) throws Exception {
        Thread.sleep(15000);
        List<byte[]> list = new ArrayList<byte[]>();


        for (int i = 0; i < 30; i++) {
            list.add(new byte[_1MB]);
            Thread.sleep(100);
        }
        list = null;
        System.gc();

        Thread.sleep(2000);
    }
}