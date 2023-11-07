package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * InputStream的使用
 */
public class Demo9 {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("d:/test.txt")) {
            while (true) {
                byte[] bytes = new byte[1024];
                int n = inputStream.read(bytes);

                if (n == -1) {
                    break;
                }

                System.out.println("n = " + n);

                for (int i = 0; i < n; i++) {
                    System.out.printf("%x\n", bytes[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
