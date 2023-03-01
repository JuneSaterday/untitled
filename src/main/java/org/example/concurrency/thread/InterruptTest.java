package org.example.concurrency.thread;

public class InterruptTest {


    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            Thread currentThread = Thread.currentThread();
            while (true) {
                if (currentThread.isInterrupted()) {
                    break;
                }
                // 省略业务代码无数
                System.out.println("currentThread is running");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    /**
                     *
                     * interrupt不会结束线程的运行，在抛出interruptedException后会清除中断标志（
                     * 代表可以接收下一个中断信号了
                     * ）
                     *
                     * currentThread不能正确退出，线程在sleep期间被打断了，抛出interruptedException,
                     *
                     * try catch 捕获此异常后，中断标识会自动清除，应该重置中断标识
                     *
                     */
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();

    }
}
