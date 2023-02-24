package org.example.three;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerTest {

    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(4);

        Producer producer1 = new Producer(blockingQueue);
        Consumer consumer1 = new Consumer(blockingQueue, "消费者1");
        Consumer consumer2 = new Consumer(blockingQueue, "消费者2");


        Thread p1 = new Thread(producer1);
        Thread c1 = new Thread(consumer1);
        Thread c2 = new Thread(consumer2);

        p1.start();
        c1.start();
        c2.start();


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c1.interrupt();
        c2.interrupt();
    }
}
