package com.lff.io.inputstream;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class InputStreamTest {


    public static void main(String[] args) {

        String path = "d:\\test\\lff.txt";

        try {
            readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    // 读取文件
    public static void readFile(String path) throws IOException {


        // 用read() 方法读取，如果文件中含有汉字，会乱码。因为一个汉字用3个字节保存，
        // read()只读1个字节，会显示乱码
        /*InputStream inputStream = new FileInputStream(path);
        int read = 0;
        while ((read = inputStream.read()) != -1) {
            System.out.print((char)read);
        }
        inputStream.close();*/


        /**
         * buff数组长度足够长，读取到汉字才不会乱码。
         * 因为有可能恰好一个汉字被两次读取，这样就显示乱码了
         *
         */
        InputStream inputStream = new FileInputStream(path);
        byte[] buff = new byte[1024];
        int read = 0;
        while ((read = inputStream.read(buff)) != -1) {
            System.out.print(new String(buff, 0, read, "utf-8"));
        }
        inputStream.close();

    }



}
