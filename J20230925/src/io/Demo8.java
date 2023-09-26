package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * write的使用
 */
public class Demo8 {
    public static void main(String[] args) {
        try (Writer writer = new FileWriter("d:/test.txt", true)) {
            //直接使用write可以写入数据
            writer.write("我在学习文件IO");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
