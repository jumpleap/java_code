package io;

import java.io.*;

public class Demo12 {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("d:/test.txt")) {
            //吧字节流转化字符流
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println("hello");
            //刷新缓冲区
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
