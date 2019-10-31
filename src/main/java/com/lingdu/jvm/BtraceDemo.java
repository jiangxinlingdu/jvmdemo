package com.lingdu.jvm;

/**
 * btrace pid BtraceSys.java
 */
public class BtraceDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.gc();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
