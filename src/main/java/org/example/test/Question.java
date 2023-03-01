package org.example.test;

public class Question {

    public static void main(String[] args) {
        new C();
    }
}


class A {
    int a = 1;

    public A() {
        a = 2;
    }
}

class B extends A {

    int b = 2;

    public B() {
        b = 3;
    }
}

class C extends B {
    private int c = 3;

    public C() {
        super();
        c = 4;
        print();

    }


    public void print() {
        System.out.println("" + a + b + c);
    }
}
