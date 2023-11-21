package io;

import java.io.*;
import java.util.Scanner;

public class TransferMethod {
    // 把写入文件的二进制数据转为字符串
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("d:/test.txt")) {
            // 直接通过printlnWriter 进行写, 写的类型是字符型
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("hello, world");
            // 需要刷新缓冲区
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 把二进制读取到的数据转化为字符串
    public static void main1(String[] args) {
        try (InputStream inputStream = new FileInputStream("d:/test.txt")) {
            // 把读取到的字节转为成字符
            Scanner scanner = new Scanner(inputStream);
            String s = scanner.next();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
