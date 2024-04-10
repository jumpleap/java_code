package ee_basic.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// Writer 写数据
public class Demo8 {
    public static void main(String[] args) {
        // 往test.txt文件中写入数据
        try (Writer writer = new FileWriter("d:/test.txt", true)) {
            writer.write(1);
            writer.write("hello, Spring!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
