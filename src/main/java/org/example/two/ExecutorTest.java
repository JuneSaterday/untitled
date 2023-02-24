package org.example.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorTest {


    public static void main(String[] args) {

        int a = Integer.SIZE - 3;

        System.out.println("running :" + (-1 << a));
        System.out.println("shutdown :" + (0 << a));
        System.out.println("stop :" + (1 << a));
        System.out.println("tidying :" + (2 << a));
        System.out.println("terminated :" + (3 << a));

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Task());


//        executorService.shutdown();


    }



    static class Task implements Runnable {


        @Override
        public void run() {
            System.out.println("run");
        }
    }
}
