package org.example.one;

import org.apache.kafka.common.protocol.types.Field;

import java.util.ArrayList;
import java.util.List;

public class FinalAndFinallyAndFinalizeTest {

    public static void main(String[] args) {



        final List<String> list = new ArrayList<>();

        list.add("1");
        list.add("2");

//        List<String> unmodifiableStrList = List.of("Hello", "world");

//        unmodifiableStrList.add("again");

        System.runFinalization();

    }



}
