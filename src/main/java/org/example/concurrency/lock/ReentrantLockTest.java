package org.example.concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {


    private int value;

    private final Lock rtl = new ReentrantLock();


    public int get() {
        rtl.lock();

        try {
            return value;
        } finally {
            rtl.unlock();
        }
    }


    public int getInterruptibly() {
        try {
            rtl.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            return value;
        } finally {
            rtl.unlock();
        }
    }

    public void addOne() {
        rtl.lock();

        try {
            value += 1;
        } finally {
            rtl.unlock();
        }
    }


    public static void main(String[] args) {

        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();


        reentrantLockTest.addOne();

        reentrantLockTest.get();



        int a;

//        System.out.println(a);


    }
}
