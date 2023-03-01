package org.example.concurrency.thread;

public class ThreadState {


    public static void main(String[] args) {

        Thread thread2 = new Thread(() -> {
            synchronized (ThreadState.class) {
                System.out.println(Thread.currentThread().getName() + "获得锁" + ThreadState.class.getSimpleName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "执行成功");
            }
        });
        thread2.setName("thread2");


        Thread thread1 = new Thread(() -> {
            try {
                thread2.join(1000);
//                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (ThreadState.class) {
                System.out.println(Thread.currentThread().getName() + "获得锁" + ThreadState.class.getSimpleName());
            }
        });
        thread1.setName("thread1");


        /** 线程创建出来状态是NEW */
        System.out.println(thread1.getName() + "状态" + thread1.getState());

        thread1.start();
        thread2.start();

        /** 线程状态从NEW -> RUNNABLE */
        System.out.println(thread1.getName() + "状态" + thread1.getState());


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /** 线程执行完 thread2.join(long millis)方法 从RUNNABLE -> TIMED_WAITING */
        System.out.println(thread1.getName() + "状态" + thread1.getState());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /** 线程等待获取synchronized隐式锁 从TIMED_WAITING -> BLOCKED */
        System.out.println(thread1.getName() + "状态" + thread1.getState());


        thread2.interrupt();
        /** 调用 interrupt() 方法，BLOCKED -> TERMINATED*//*
        System.out.println(thread1.getName() + "状态" + thread1.getState());*/

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /** 线程执行完 run()方法 从RUNNABLE -> TERMINATED*/
        System.out.println(thread1.getName() + "状态" + thread1.getState());



    }
}
