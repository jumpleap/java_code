package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Writer的使用
 */
public class Demo8 {
    public static void main(String[] args) {
        try (Writer writer = new FileWriter("d:/test.txt", true)) {
            writer.write("我在学习文件IO!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
