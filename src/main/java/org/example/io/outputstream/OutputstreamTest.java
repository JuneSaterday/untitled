package org.example.io.outputstream;

import java.io.*;

public class OutputstreamTest {

    public static void main(String[] args) {
        String path = "d:\\test\\choubao.txt";

        try {
            writeFile(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 写入文件，单个字符
    public static void writeFile(String path) throws FileNotFoundException {

        File file = new File(path);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        OutputStream outputStream = new FileOutputStream(path);


        try {
            /*// 每次写单个字符
            outputStream.write('l');
            outputStream.write('f');
            outputStream.write('f');
            outputStream.write('l');
            outputStream.write('o');
            outputStream.write('v');
            outputStream.write('e');
            outputStream.write('冷');*/

            // 写字符串
            String string = "臭宝，我爱你";
            outputStream.write(string.getBytes());
            outputStream.write(string.getBytes(), 0, string.getBytes().length);

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
