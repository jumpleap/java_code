package ee_basic.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

// Scanner从文件中读取数据
public class Demo11 {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("d:/test.txt")) {
            // 从test.txt中读取数据
            Scanner scanner = new Scanner(inputStream);
            // 读取多个数据
            while (scanner.hasNext()) {
                // 读取数据, 遇到空格,tab符等结束读取
                String str = scanner.next();
                System.out.println(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
