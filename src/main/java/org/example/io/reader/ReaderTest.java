package com.lff.io.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderTest {


    public static void main(String[] args) {



        String path = "d:\\test\\lff.txt";

        try {
            readFile(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }



    public static void readFile(String path) throws FileNotFoundException {

        Reader reader = new FileReader(path);
        int read = -1;

        char[] buff = new char[2];

        try {
            // 每次读取单个字符
            /*while ((read = reader.read()) != -1) {
                System.out.print((char) read);
            }*/

            while ((read = reader.read(buff, 0, buff.length)) != -1) {
                for (int i = 0; i < read; i++) {
                    System.out.print(buff[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
