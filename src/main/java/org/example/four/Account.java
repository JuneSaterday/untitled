package org.example.four;

public class Account {


    public Account(Integer balance) {
        this.balance = balance;
    }

    public Account(Integer balance, Object lock) {
        this.balance = balance;
        this.lock = lock;
    }

    private Integer balance;

    private Object lock;


    /*private synchronized void transfer(Account target, Integer amt) {
        balance = balance - amt;
        target.setBalance(target.getBalance() + amt);
    }*/

    private synchronized void transfer(Account target, Integer amt) {
//        synchronized (lock) {

            if (balance > amt) {
                balance -= amt;
                target.balance += amt;
            }
//        }
    }


    public synchronized Integer getBalance() {
        return balance;
    }

    public synchronized void setBalance(Integer balance) {
        this.balance = balance;
    }


    public static void main(String[] args) {

        Object lock = new Object();

        Account a = new Account(200, lock);
        Account b = new Account(200, lock);
        Account c = new Account(200, lock);

        new Thread(() -> {
            a.transfer(b, 100);
        }).start();

        new Thread(() -> {
            b.transfer(c, 100);
        }).start();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("A count balance" + a.getBalance());
        System.out.println("B count balance" + b.getBalance());
        System.out.println("C count balance" + c.getBalance());
    }
}
