package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * OutputStream的使用
 */
public class Demo10 {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("d:/test.txt")) {
            String s = "我好爱这个世界啊!";
            outputStream.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
