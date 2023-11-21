package io;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        // 创建文件
        File file = new File("d:/test.txt");
        file.createNewFile();

        // 读取文件内容
        try (Reader reader = new FileReader("d:/test.txt")) {
            while (true) {
                // 把内容存储到该字符数组中
                char[] cbuf = new char[10];
                // n 是读取到的字符个数
                int n = reader.read(cbuf);

                // n == -1说明文件已经读取结束
                if (n == -1) {
                    break;
                }

                System.out.println("n = " + n);

                // 把读取到的字符打印出来
                for (int i = 0; i < n; i++) {
                    System.out.print(cbuf[i] + "");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        };
    }
}
