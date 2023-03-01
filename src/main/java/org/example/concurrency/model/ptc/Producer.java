package org.example.concurrency.model.ptc;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    private BlockingQueue<Integer> blockingQueue;


    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    private int seq;

    private int produce() {
        return seq++;
    }


    @Override
    public void run() {
        while (true) {
            try {
                blockingQueue.put(produce());
                System.out.println("生产者生产任务" + seq);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
