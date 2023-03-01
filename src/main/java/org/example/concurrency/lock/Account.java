package org.example.concurrency.lock;

public class Account {


    /**资源id，以便可以线性申请资源 */
    private int id;


    public Account(Integer balance) {
        this.balance = balance;
    }

    private Integer balance;

    private Object lock;

    /*public Account(Integer balance, Object lock) {
        this.balance = balance;

        *//** 创建Account时，可以传入同一把锁*//*
        this.lock = lock;
    }*/

    public Account(int id, Integer balance) {
        this.id = id;
        this.balance = balance;
    }

    /**
     * 这个方法加synchronized没用。
     *
     * @param target
     * @param amt
     */
    private void transfer(Account target, Integer amt) {

        /*if (balance > amt) {
            balance = balance - amt;
            target.balance += amt;
        }*/

        /** 共享锁lock保护 */
        /*synchronized (lock) {
            if (balance > amt) {
                balance = balance - amt;
                target.balance += amt;
            }
        }*/

        /** Account.class锁保护 */
        /*synchronized (Account.class) {
            if (balance > amt) {
                balance = balance - amt;
                target.balance += amt;
            }
        }*/

        /** 使用from account, to account 两把锁 */
        /*synchronized (this) {
            synchronized (target) {
                if (balance > amt) {
                    balance = balance - amt;
                    target.balance += amt;
                }
            }
        }*/

        Account left;
        Account right;

        if (id > target.id) {
            left = target;
            right = this;
        }
        left = this;
        right = target;
        synchronized (left) {
            synchronized (right) {
                if (balance > amt) {
                    balance = balance - amt;
                    target.balance += amt;
                }
            }
        }


    }


    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }


    public static void main(String[] args) {
        Account a = new Account(1, 200);
        Account b = new Account(2, 200);
        Account c = new Account(200);


        Thread thread1 = new Thread(() -> {
            a.transfer(b, 100);
        });

        /*Thread thread2 = new Thread(() -> {
            b.transfer(c, 100);
        });*/

        Thread thread2 = new Thread(() -> {
            b.transfer(a, 100);
        });


        thread2.start();
        thread1.start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 同时转账的话，可能出现的异常情况：
         * 1.
         * a count balance100
         * b count balance300
         * c count balance300
         *
         * 2.
         * a count balance100
         * b count balance100
         * c count balance300
         *
         *
         */
        System.out.println("a count balance" + a.getBalance());
        System.out.println("b count balance" + b.getBalance());
        System.out.println("c count balance" + c.getBalance());


        /**
         * 用一把锁来保护转账关联的两个账号的临界资源
         *
         * 1.Account.class，缺点就是锁的粒度太大了
         *
         * 2.创建账户时，传入同一把锁lock，真实场景中，传入共享的lock太难
         *
         * 3.使用from account, to account 两把锁，注意使用，如果两个账户间相互转账，容易死锁
         *
         */


    }
}
