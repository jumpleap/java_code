package io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Reader的使用
 */
public class Demo7 {
    public static void main(String[] args) throws IOException {
        //Reader reader = new FileReader("d:/test.txt");

        //1.一次读一个字符
        //该操作不正确, 会出现文件资源泄露
        /*while (true) {
            int c = reader.read();
            //读取文件结束了
            if (c == -1) {
                break;
            }

            //把读取到的转为字符
            char ch = (char) c;
            System.out.println(ch);
        }*/

        //2. 一次读多个字符, 使用try - finally的方式 不够优雅
        /*try {
            while (true) {
                char[] cbuf = new char[1024];
                int n = reader.read(cbuf);
                //n表示当前读到的字符个数
                if (n == -1) {
                    //读取结束
                    break;
                }
                System.out.println("n = " + n);

                for (int i = 0; i < n; i++) {
                    System.out.println(cbuf[i]);
                }
            }
        } finally {
            //一个文件使用完了 记得要close
            reader.close();
        }*/


        //优雅的方式, 不存在问题
        try (Reader reader = new FileReader("d:/test.txt")) {
            while (true) {
                char[] cbuf = new char[1024];
                int n = reader.read(cbuf);

                if (n == -1) {
                    //读取结束
                    break;
                }

                System.out.println("n = " + n);

                for (int i = 0; i < n; i++) {
                    System.out.println(cbuf[i]);
                }
            }
        }
    }
}
