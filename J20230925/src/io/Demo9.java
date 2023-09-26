package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Demo9 {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("d:/test.txt")) {
            byte[] bytes = new byte[1024];
            int n = inputStream.read(bytes);
            System.out.println("n = " + n);
            for (int i = 0; i < n; i++) {
                System.out.printf("%x\n", bytes[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
