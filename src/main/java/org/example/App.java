package org.example;


import javafx.concurrent.Task;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {


    public static void main(String[] args) {


//
//        try {
//            int i = Loading.i;
//        } catch (Error e) {
//
//            System.out.println(e);
//        }
//
//        Loading.print();

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        try {
            queue.put("1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            queue.put("2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(queue);
    }


}
