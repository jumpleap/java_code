package io;

import java.io.File;
import java.io.IOException;

/**
 * 文件方法的基本使用
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        //文件不存在的情况下
        File file = new File("d:/test.txt");
        //判断文件是否存在
        System.out.println(file.exists());
        //判断当前file对象是不是目录
        System.out.println(file.isDirectory());
        //判断当前file对象是不是文件
        System.out.println(file.isFile());

        //创建文件
        boolean ans = file.createNewFile();
        System.out.println("ans = " + ans);

        //文件存在的情况下继续判断
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
    }
}
