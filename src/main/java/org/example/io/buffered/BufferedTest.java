package com.lff.io.buffered;

import java.io.*;

public class BufferedTest {

    public static void main(String[] args) {
//        String srcPath = "d:\\test\\lff.txt";
        String srcPath = "d:\\test\\lff_buffered.txt";
        try {
//            readFile(srcPath);
            writeFile(srcPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(String path) throws FileNotFoundException {

        InputStream inputStream = new FileInputStream(path);
        inputStream = new BufferedInputStream(inputStream);

        byte[] buff = new byte[2048];
        int read = -1;

        try {
            while ((read = inputStream.read(buff, 0, buff.length)) != -1) {
                System.out.print(new String(buff, 0, read));
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


    public static void writeFile(String path) throws FileNotFoundException {

        OutputStream outputStream = new FileOutputStream(path);
        outputStream = new BufferedOutputStream(outputStream);

        String s = "臭宝，我想你。2022-12-04 15:49臭宝，我想你。2022-12-04 15:49";
        try {
            outputStream.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
