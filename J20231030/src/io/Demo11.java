package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * InputStream利用Scanner读取字符串
 */
public class Demo11 {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("d:/test.txt")) {
            Scanner scanner = new Scanner(inputStream);
            //利用scanner读取后续的数据, 即利用Scanner把字节流读取为字符流
            String s = scanner.next();
            System.out.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
