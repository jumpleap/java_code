package io;

import java.io.File;
import java.io.IOException;

/**
 * 文件方法的基本使用
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        //File file = new File("d:/test.txt");
        File file = new File("./test.txt");
        System.out.println(file.getParent()); //获取父路径
        System.out.println(file.getName()); //获取文件名称
        System.out.println(file.getPath()); //获取文件的路径
        System.out.println(file.getAbsolutePath()); //文件的绝对路径
        System.out.println(file.getCanonicalFile()); //文件的绝对路径, 精简过了
    }
}
