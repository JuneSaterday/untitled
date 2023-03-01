package com.lff.io.file;

import java.io.*;
import java.util.Date;

public class FileCopyTest {


    public static void main(String[] args) {


        String srcPath = "d:\\test\\lff.txt";
//        String desPath = "d:\\test\\lff_2.txt";
        String desPath = "d:\\test";

//        String srcPath = "d:\\test\\Blood on the Tracks.mp4";
//        String desPath = "d:\\test\\Blood on the Tracks 2.mp4";

        System.out.println("copy start:" + new Date());
        try {

            copyFile(srcPath, desPath);

//            copyFileUseChar(srcPath, desPath);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("copy end:" + new Date());


    }



    public static void copyFile(String srcPath, String desPath) throws FileNotFoundException {
        InputStream inputStream = new  FileInputStream(srcPath);
        FileOutputStream outputStream = new FileOutputStream(desPath);

        byte[] buff = new byte[2048];
        int length = -1;
        try {
            while ((length = inputStream.read(buff, 0, buff.length)) != -1) {
                outputStream.write(buff, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public static void copyFileUseChar(String srcPath, String desPath) throws IOException {
        Reader reader = new  FileReader(srcPath);
        Writer writer = new FileWriter(desPath);

        char[] chars = new char[2];
        int length = -1;
        try {
            while ((length = reader.read(chars, 0, chars.length)) != -1) {
                writer.write(chars, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
