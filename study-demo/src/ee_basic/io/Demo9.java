package ee_basic.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// InputStream 读数据
public class Demo9 {
    public static void main(String[] args) {
        // 读取test.txt中的数据
        try (InputStream inputStream = new FileInputStream("d:/test.txt")) {
            // 创建字节数组, 用于存储数据
            byte[] cbuf = new byte[1024];
            // 读取数据, 把读取到的数据存储到字节数组中
            int line = inputStream.read(cbuf);

            // 打印数据
            System.out.println(line);
            for (int i = 0; i < line; i++) {
                char ch = (char) cbuf[i];
                System.out.println(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
