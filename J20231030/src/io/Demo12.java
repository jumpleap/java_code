package io;

import java.io.*;

/**
 * OutputStream利用PrintWriter来输出字符到文件
 */
public class Demo12 {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("d:/test.txt")) {
            //相当于把字节流转化为字符流了
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("hello, world");
            //刷新缓冲区
            printWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
