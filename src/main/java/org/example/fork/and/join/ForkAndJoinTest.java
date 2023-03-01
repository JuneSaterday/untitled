package com.lff.fork.and.join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkAndJoinTest {

    public static void main(String[] args) {


        ForkJoinPool forkJoinPool = new ForkJoinPool(4);


        Fibonacci fibonacci = new Fibonacci(30);

        Integer result = forkJoinPool.invoke(fibonacci);

        System.out.println(result);


        String s = "zss-love-lff";

        System.out.println(s.replace("s", ""));
    }


    static class Fibonacci extends RecursiveTask<Integer> {
        final int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n <= 1) {
                return n;
            }

            Fibonacci f1 = new Fibonacci(n-1);
            // 创建子任务
            f1.fork();

            Fibonacci f2 = new Fibonacci(n-2);
            // 等待子任务结果，并合并结果
            return f2.compute() + f1.join();
        }
    }
}
