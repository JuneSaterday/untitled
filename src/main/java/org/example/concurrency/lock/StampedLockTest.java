package org.example.concurrency.lock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {


    final StampedLock stampedLock = new StampedLock();

    private int x, y;

    public StampedLockTest(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 悲观读锁
     */
    public void readLock() {
        long stamp = stampedLock.readLock();

        try {
            //业务代码

        } finally {
            stampedLock.unlock(stamp);
        }
    }

    /**
     * 乐观读
     */
    public int optimisticRead() {

        long stamp = stampedLock.tryOptimisticRead();

        // 读入方法局部变量
        int curX = x;
        int curY = y;

        // 校验stamp
        if (!stampedLock.validate(stamp)) {

            System.out.println("乐观读失败");

            // 升级为悲观读锁
            long stampRead = stampedLock.readLock();

            try {
                // 读入方法局部变量
                curX = x;
                curY = y;

            } finally {
                stampedLock.unlockRead(stampRead);
            }
        }
        // 使用方法局部变量执行业务代码
        return Math.addExact(curX, curY);
    }

    /**
     * 写锁
     */
    public void writeLock(int curX, int curY) {

        long stamp = stampedLock.writeLock();

        try {
            // 业务代码
            x = curX;
            y = curY;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }


    public static void main(String[] args) {


        StampedLockTest stampedLockTest = new StampedLockTest(1, 2);




        Thread thread1 = new Thread(() -> {

            int optimisticRead1 = stampedLockTest.optimisticRead();

            System.out.println("乐观读的结果" + optimisticRead1);

        });

        Thread thread2 = new Thread(() -> {

            stampedLockTest.writeLock(2, 2);

            System.out.println("写锁的结果" + (stampedLockTest.x + stampedLockTest.y));

        });

        thread1.start();

        thread2.start();

        /**
         * 乐观读失败
         * 写锁的结果4
         * 乐观读的结果4
         *
         */



    }
}
