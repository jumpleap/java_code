package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class WriterFile {
    public static void main(String[] args) throws IOException {
        // 创建文件
        File file = new File("d:/test.txt");
        file.createNewFile();

        // 写文件
        Scanner scanner = new Scanner(System.in);
        try (Writer writer = new FileWriter("d:/test.txt",true)) {
                String s = scanner.next();
                writer.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}