package org.example.four;

public class ThreadTest {

    int i = 10;
    volatile boolean flag = false;

    public static void main(String[] args) {


    }


    private void write() {
        i = 42;
        flag = true;
    }

    private void read() {
        System.out.println(flag);
        System.out.println(i);
    }
}
