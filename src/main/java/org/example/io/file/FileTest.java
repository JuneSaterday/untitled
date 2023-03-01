package org.example.io.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileTest {


    public static void main(String[] args) throws IOException {


        File file = new File("d:\\test\\lff.txt");

        System.out.println("文件名称：" + file.getName());
        System.out.println("文件绝对路径：" + file.getAbsolutePath());
        System.out.println("文件标准规范路径名：" + file.getCanonicalPath());
        System.out.println("文件大小：" + file.length());
        System.out.println("文件上级："+ file.getParent());
        System.out.println("文件是否存在："+ file.exists());
        System.out.println("文件未分配空间大小：" + file.getFreeSpace());
        System.out.println("文件是否是文件夹：" + file.isDirectory());
        System.out.println("文件是否是文件：" + file.isFile());
        File parentFile = file.getParentFile();
        String[] list = parentFile.list();
        System.out.println("文件同级的其他文件：" + Arrays.toString(list));



        createFile("d:\\test\\zss.txt");
        createDirectory("d:\\test\\20221203\\miss_you");
    }




    private static void createFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            boolean newFile = file.createNewFile();
            System.out.println("创建文件：" + path + (newFile ? "成功" : "失败"));
        }
    }


    private static void createDirectory(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            boolean mkdir = file.mkdirs();
            System.out.println("创建文件夹：" + path + (mkdir ? "成功" : "失败"));
        }
    }
}
