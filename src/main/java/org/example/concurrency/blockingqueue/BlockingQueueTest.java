package org.example.concurrency.blockingqueue;

import javafx.concurrent.Task;

import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {


    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue<String> objects = new LinkedBlockingQueue<>(2);


        Thread thread1 = new Thread(() -> {
            try {
                objects.put("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(objects);
            try {
                objects.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(objects);
            try {
                objects.put("4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(objects);
        });


        Thread thread2 = new Thread(() -> {

            String take = null;
            try {
                take = objects.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(take);
        });

        thread1.start();
        Thread.sleep(20000);
        thread2.start();

    }
}
