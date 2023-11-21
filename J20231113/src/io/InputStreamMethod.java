package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamMethod {
    // 以二进制的方式的读文件
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("d:/test.txt")) {
            while (true) {
                // 读取文件中的字节
                byte[] bytes = new byte[10];
                int n = inputStream.read(bytes);

                // 读取文件结束
                if (n == -1) {
                    break;
                }

                // 打印字节
                System.out.println("n = " + n);
                for (int i = 0; i < n; i++) {
                    // 使用println打印出来的是十进制, 我们使用souf来进行解决
                    // System.out.println(bytes[i]);
                    System.out.printf("%x\n", bytes[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
