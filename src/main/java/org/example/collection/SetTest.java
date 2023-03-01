package com.lff.collection;

import java.util.HashSet;
import java.util.Objects;

public class SetTest {


    public static void main(String[] args) {


        HashSet<Object> set = new HashSet<>();


//        // resize
//        for (int i = 0; i < 100; i++) {
//            set.add(i);
//        }
//        System.out.println(set);


        // treeify
        for (int i = 1; i <= 12; i++) {
            set.add(new A(i));

            // resize
        }

        System.out.println(set);
    }
}


class A {

    private int i;


    public A(int i) {
        this.i = i;
    }


    @Override
    public int hashCode() {
        return 100;
    }
}
