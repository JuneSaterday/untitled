package org.example.one;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

    public static void main(String[] args) {


        Map hashMap = new HashMap();

        hashMap.put(null, 1);
        hashMap.put(1, null);
        hashMap.put(null, null);

        System.out.println(hashMap);


        Map concurrentHashMap = new ConcurrentHashMap<>();

        concurrentHashMap.put(null, 1);


    }
}
