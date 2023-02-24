package org.example.three;

import javafx.concurrent.Task;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private String name;

    private BlockingQueue<Integer> blockingQueue;


    public Consumer(BlockingQueue blockingQueue, String name) {
        this.blockingQueue = blockingQueue;

        this.name = name;
    }


    private void consume(int take) {

        System.out.println(name + "消费任务" + take);

    }



    @Override
    public void run() {

        while (true) {
            try {
                consume(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();

                System.out.println(name + "线程中断标志" + Thread.currentThread().isInterrupted());

                break;
            }
        }
    }
}
