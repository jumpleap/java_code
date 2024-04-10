package ee_basic.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// Reader读取数据
public class Demo7 {
    public static void main(String[] args) throws IOException {
        // 初始化reader对象
//        Reader reader = new FileReader("d:/test.txt");

        // 1.一次read一个字符
//        while (true) {
//            // 读取一个数
//            int num = reader.read();
//            // n为-1, 说明读完了
//            if (num == -1) {
//                break;
//            }
//            // 把读到的数转为字符
//            char ch = (char)num;
//            System.out.println(ch);
//        }

        // 一次读多个字符

//        try {
//            while (true) {
//                // 使用字符数组来进行读取
//                char[] cbuf = new char[3];
//                // 读取多个字符, n表示读到字符的个数
//                int n = reader.read(cbuf);
//                // n为-1, 说明读完了
//                if(n == -1) break;
//                // 打印字符数组中的字符
//                System.out.println(n);
//                for (int i = 0; i < n; i++) {
//                    System.out.println(cbuf[i]);
//                }
//            }
//        } finally {
//            // 读完文件后, 记得close
//            reader.close();
//        }

        // 最优雅的代码
        try (Reader reader = new FileReader("d:/test.txt")) {
            while (true) {
                // 创建字符数组用于读取数据
                char[] cbuf = new char[3];
                // 使用字符数组存储读取到的数据, line表示读取到几个字符
                int line = reader.read(cbuf);

                // line为-1, 说明读取结束
                if (line == -1) break;

                // 打印读取到的字符
                System.out.println(line);
                for (int i = 0; i < line; i++) {
                    System.out.println(cbuf[i]);
                }
            }
        }
    }
}
