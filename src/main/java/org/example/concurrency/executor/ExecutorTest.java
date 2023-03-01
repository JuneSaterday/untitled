package org.example.concurrency.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class ExecutorTest {

    private static final Logger log = LoggerFactory.getLogger(ExecutorTest.class);


    public static void main(String[] args) {

/*        int a = Integer.SIZE - 3;

        System.out.println("running :" + (-1 << a));
        System.out.println("shutdown :" + (0 << a));
        System.out.println("stop :" + (1 << a));
        System.out.println("tidying :" + (2 << a));
        System.out.println("terminated :" + (3 << a));

        ExecutorService executorService = Executors.newSingleThreadExecutor();*/


        NamedThreadFactory namedThreadFactory = new NamedThreadFactory("myPool", false);


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4,
                20, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2),
                namedThreadFactory
        );

        for (int i = 0; i < 10; i++) {


            Task task = new Task(String.valueOf(i));

            try {
                threadPoolExecutor.execute(task);
                printThreadPoolExexutorStatus(threadPoolExecutor);
            } catch (RejectedExecutionException ex) {

                log.error("线程池拒绝任务" + task, ex);
            }

        }


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printThreadPoolExexutorStatus(threadPoolExecutor);

        threadPoolExecutor.allowCoreThreadTimeOut(true);

        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printThreadPoolExexutorStatus(threadPoolExecutor);

    }


    static class Task implements Runnable {

        final String taskName;

        public Task(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            log.info(taskName + "running");
        }
    }



    public static void printThreadPoolExexutorStatus(ThreadPoolExecutor threadPoolExecutor) {


        log.info("=======================================");
        log.info("当前排队线程数：" + threadPoolExecutor.getQueue().size());
        log.info("当前活动线程数：" + threadPoolExecutor.getActiveCount());
        log.info("当前corePoolSize：" + threadPoolExecutor.getCorePoolSize());

        log.info("当前完成线程数：" + threadPoolExecutor.getCompletedTaskCount());
        log.info("线程池曾经达到的最大线程数：" + threadPoolExecutor.getLargestPoolSize());
        log.info("线程池设置的最大线程数：" + threadPoolExecutor.getMaximumPoolSize());
        log.info("=======================================");
    }
}
