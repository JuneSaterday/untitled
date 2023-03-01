package com.lff.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {


    public static void main(String[] args) {


        try {

//            writeFile("d:\\test\\yanchi.txt");

            readFile("d:\\test\\lff.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


    public static void writeFile(String  path) throws FileNotFoundException {


        String s = "春江花月夜 2022-12-04 22:10";

        FileOutputStream outputStream = new FileOutputStream(path);
        FileChannel channel = outputStream.getChannel();

        ByteBuffer allocate = ByteBuffer.allocate(2048);
        allocate.put(s.getBytes());
        allocate.flip();

        try {
            channel.write(allocate);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readFile(String path) throws FileNotFoundException {

        FileInputStream inputStream = new FileInputStream(path);
        FileChannel channel = inputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(2);

        int read = -1;

        try {
            while ((read = channel.read(buffer)) != -1) {

                buffer.flip();
                System.out.print(new String(buffer.array(), 0, read));

//                buffer.clear();


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
