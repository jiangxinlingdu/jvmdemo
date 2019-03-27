package com.imooc.jvm;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 让4个线程，相互死锁(A等待B，B等待C，C等待D，D等待A)。。
 */
public class DeadLockDemo extends Thread {
    private ReentrantLock reentrantLock;
    static ReentrantLock a = new ReentrantLock();
    static ReentrantLock b = new ReentrantLock();
    static ReentrantLock c = new ReentrantLock();
    static ReentrantLock d = new ReentrantLock();

    public DeadLockDemo(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
        if (this.reentrantLock == a) {
            this.setName("A");
        }
        if (this.reentrantLock == b) {
            this.setName("B");
        }
        if (this.reentrantLock == c) {
            this.setName("C");
        }
        if (this.reentrantLock == d) {
            this.setName("D");
        }
    }

    @Override
    public void run() {
        if (this.reentrantLock == b) {
            try {
                a.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                b.lockInterruptibly();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } finally {
                if (a.isHeldByCurrentThread())
                    a.unlock();
                if (b.isHeldByCurrentThread())
                    b.unlock();
            }

        }
        if (this.reentrantLock == c) {
            try {
                b.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                c.lockInterruptibly();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } finally {
                if (c.isHeldByCurrentThread())
                    c.unlock();
                if (b.isHeldByCurrentThread())
                    b.unlock();
            }

        }
        if (this.reentrantLock == d) {
            try {
                c.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                d.lockInterruptibly();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } finally {
                if (c.isHeldByCurrentThread())
                    c.unlock();
                if (d.isHeldByCurrentThread())
                    d.unlock();
            }

        }
        if (this.reentrantLock == a) {
            try {
                d.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                a.lockInterruptibly();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } finally {
                if (d.isHeldByCurrentThread())
                    d.unlock();
                if (a.isHeldByCurrentThread())
                    a.unlock();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLockDemo aThread = new DeadLockDemo(a);
        DeadLockDemo bThread = new DeadLockDemo(b);
        DeadLockDemo cThread = new DeadLockDemo(c);
        DeadLockDemo dThread = new DeadLockDemo(d);
        aThread.start();
        bThread.start();
        cThread.start();
        dThread.start();
        Thread.sleep(1000);
    }
}