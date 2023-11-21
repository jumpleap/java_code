package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class OutputStreamMethod {
    // 以二进制的方式写文件
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (OutputStream outputStream = new FileOutputStream("d:/test.txt")) {
            // 输入你想要写文件的字符串
            String s = scanner.next();
            // 把字符串转为二进制, 写到文件中
            outputStream.write(s.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
