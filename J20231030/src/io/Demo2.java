package io;

import java.io.File;
import java.io.IOException;

/**
 * 文件方法的使用
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("./test.txt");
        System.out.println(file.exists());//判断文件是否存在
        System.out.println(file.isDirectory()); //判断当前文件是否是目录
        System.out.println(file.isFile()); //判断当前文件是否是文件

        //创建文件
        System.out.println(file.createNewFile());

        System.out.println(file.exists());//判断文件是否存在
        System.out.println(file.isDirectory()); //判断当前文件是否是目录
        System.out.println(file.isFile()); //判断当前文件是否是文件
    }
}
