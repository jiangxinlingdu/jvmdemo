package com.imooc.jvm.test1;




public class Test {
    private static final int _1MB = 1024 * 1024;

        /*
       -Xmx20m
       -Xms20m
       -Xmn10m
       -XX:+UseParNewGC
       -XX:+UseConcMarkSweepGC
       -XX:+UseCMSInitiatingOccupancyOnly
       -XX:CMSInitiatingOccupancyFraction=75
       */
    public static void main(String[] args) throws Exception {
        byte[] all1 = new byte[2 * _1MB];
        byte[] all2 = new byte[2 * _1MB];
        byte[] all3 = new byte[2 * _1MB];
        byte[] all4 = new byte[7 * _1MB];
        System.in.read();
    }
}