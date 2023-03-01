package org.example.concurrency.thread;

public class ThreadLocalTest {





    static ThreadLocal<Integer> threadLocal = new ThreadLocal();

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        System.out.println(thread);
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread());

            threadLocal.set(1);


            System.out.println("thread:" + Thread.currentThread().getName() + threadLocal.get());

        });

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread());

            threadLocal.set(2);


            System.out.println("thread:" + Thread.currentThread().getName() + threadLocal.get());

        });

        thread1.start();
        thread2.start();


    }
}
