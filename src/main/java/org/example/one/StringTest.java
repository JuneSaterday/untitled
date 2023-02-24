package org.example.one;

import java.util.ArrayList;
import java.util.List;

public class StringTest {

    public static void main(String[] args) {

        int a = 16;
        System.out.println(a << 1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("012345678912345");
        stringBuilder.append("6");
        stringBuilder.append("7");

        for (int i = 0; i < 18; i++) {
            stringBuilder.append("1");
        }




        /*List list = new ArrayList();
        String str = "hello";
        for(int i = 0;i < Integer.MAX_VALUE;i++) {
            String s = str + i;
            str = s;
            list.add(s.intern());
        }*/

        String str = "hello";
        for(int i = 0;i < 10000;i++) {
            String s = str + i;
            s.intern();
        }


    }
}
