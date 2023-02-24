package org.example;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.common.protocol.types.Field;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

public class Test {


    public static void main(String[] args) {

        Map map = new HashMap<>();

        for (int i = 0; i < 15; i++) {
            map.put(new A(i), null);
        }

        Object o = map.get(new A(2));

        System.out.println(o);


        Map map1 = Collections.synchronizedMap(map);


        // 找到大于或等于 cap 的最小2的幂

//        /**
//         * Returns a power of two size for the given target capacity.
//         */
//        static final int tableSizeFor(int cap) {
//            int n = cap - 1;
//            n |= n >>> 1;
//            n |= n >>> 2;
//            n |= n >>> 4;
//            n |= n >>> 8;
//            n |= n >>> 16;
//            return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
//        }




        // tab[(n - 1) & hash]

        TreeMap<String, String> treeMap = new TreeMap<>();

        treeMap.put("zss", "lff");



    }




}


@Getter
@Setter
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
