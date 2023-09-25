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

        //1.一次read一个字符
        /*
        while (true) {
            int num = reader.read();
            if (num == -1) {
                //没有数据可读.读取结束
                break;
            }
            char ch = (char) num;
            System.out.println(ch);
        }
        */

        //2.一次read多个字符, 不够优雅的版本
        /*
        try {
            while (true) {
                char[] cbuf = new char[3];
                //n代表当前读到的字符个数
                int n = reader.read(cbuf);
                if(n == -1) {
                    //读取完毕
                    break;
                }
                System.out.println("n = " + n);
                for (int i = 0; i < n; i++) {
                    System.out.println(cbuf[i]);
                }
            }
        } finally {
            //一个文件使用完,记得要close
            reader.close();
        }
        */

        //2.一次read多个字符, 优雅的版本
        try (Reader reader = new FileReader("d:/test.txt")) {
            while (true) {
                char[] cbuf = new char[3];
                int n = reader.read(cbuf);

                if (n == -1) {
                    break;
                }

                for (int i = 0; i < n; i++) {
                    System.out.println(cbuf[i]);
                }
            }
        }
    }
}