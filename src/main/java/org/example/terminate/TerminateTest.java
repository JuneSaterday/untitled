package com.lff.terminate;

public class TerminateTest {


    public static void main(String[] args) throws InterruptedException {

        Proxy proxy = new Proxy();
        proxy.start();

        Thread.sleep(11000);
        proxy.stop();
    }



    static class Proxy {

        // 线程终止标志位
        volatile boolean terminate = false;

        boolean started = false;

        Thread rptThread;

        synchronized void start() {

            if (started) {
                return;
            }

            started = true;

            rptThread = new Thread(() -> {

                // 判断中断标志位
                while (!Thread.currentThread().isInterrupted()) {

                    System.out.println("采集日志");

                    System.out.println("回传日志");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        /*System.out.println("收集日志线程是否中断：" + Thread.currentThread().isInterrupted());
                        // 重新设置线程中断状态
                        Thread.currentThread().interrupt();
                        System.out.println("重新设置收集日志线程的中断状态");

                        // 清除当前线程的中断状态
                        Thread.currentThread().interrupted();
                        System.out.println("收集日志线程是否中断：" + Thread.currentThread().isInterrupted());*/
                    }
                }
                started = false;
            });

            rptThread.start();
        }


        synchronized void stop() {

            terminate = true;

            rptThread.interrupt();
        }

    }
}




