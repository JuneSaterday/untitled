package org.example.four;

public class Account {


    public Account(Integer balance) {
        this.balance = balance;
    }

    private Integer balance;


    private void transfer(Account target, Integer amt) {

        balance = balance - amt;
        target.setBalance(target.getBalance() + amt);
    }


    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }


    public static void main(String[] args) {
        Account from = new Account(100);
        Account to = new Account(100);


        new Thread(() -> {
            from.transfer(to, 50);
        }).start();

        new Thread(() -> {
            to.setBalance(to.getBalance() + 21);
        }).start();


        System.out.println("from count balance" + from.getBalance());
        System.out.println("to count balance" + to.getBalance());
    }
}
