package com.lff.io.writer;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterTest {


    public static void main(String[] args) {


        String path = "d:\\test\\zss_lff.txt";

        try {
            writeFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void writeFile(String path) throws IOException {


//        Writer writer = new FileWriter(path);
        Writer writer = new FileWriter(path, true);

        String string = "臭宝，我想你。2022-12-04 15:49";
        try {
//            writer.write(string.toCharArray(), 0, string.length());

            writer.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }



        // 不使用flush或close，内容不会写到文件里
        writer.flush();
        writer.close();

    }
}
