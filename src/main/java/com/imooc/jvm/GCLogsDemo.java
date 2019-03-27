package com.imooc.jvm;




public class GCLogsDemo {
    private static final int _1MB = 1024 * 1024;


    /*
       -Xmx20m
       -Xms20m
       -Xmn10m
       -XX:+PrintGCDetails
       -XX:+PrintGCDateStamps
       -XX:+UseSerialGC
       */

    /*
       -Xmx20m
       -Xms20m
       -Xmn10m
       -XX:+PrintGCDetails
       -XX:+PrintGCDateStamps

       垃圾回收器冲突
       -XX:+UseSerialGC
       -XX:+UseConcMarkSweepGC


       -XX:+UseCMSInitiatingOccupancyOnly
       -XX:CMSInitiatingOccupancyFraction=75
       */


        /*
       -Xmx20m
       -Xms20m
       -Xmn10m
       -XX:+PrintGCDetails
       -XX:+PrintGCDateStamps
       -XX:+UseParNewGC
       -XX:+UseConcMarkSweepGC
       -XX:+UseCMSInitiatingOccupancyOnly
       -XX:CMSInitiatingOccupancyFraction=75
       */


        /*
       -Xmx20m
       -Xms20m
       -Xmn10m
       -XX:+PrintGCDetails
       -XX:+PrintGCDateStamps
       -XX:+UseParNewGC
       */


        /*
       -Xmx20m
       -Xms20m
       -Xmn10m
       -XX:+PrintGCDetails
       -XX:+PrintGCDateStamps
       -XX:+UseParallelGC
       */


        /*
       -Xmx20m
       -Xms20m
       -Xmn10m
       -XX:+PrintGCDetails
       -XX:+PrintGCDateStamps
       -XX:+UseParallelGC
       -XX:+UseParallelOldGC
       */


        /*
       -Xmx20m
       -Xms20m
       -Xmn10m
       -XX:+PrintGCDetails
       -XX:+PrintGCDateStamps
       -XX:+UseG1GC
       */





    public static void main(String[] args) throws Exception {
        byte[] all1 = new byte[2 * _1MB];
        byte[] all2 = new byte[2 * _1MB];
        byte[] all3 = new byte[2 * _1MB];
        byte[] all4 = new byte[4 * _1MB];

        Thread.sleep(5000);
        System.gc();
    }
}