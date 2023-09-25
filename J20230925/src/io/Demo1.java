package io;

import java.io.File;
import java.io.IOException;

/**
 * 文件方法的基本使用
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("./test.txt");
        //获取父目录的文件路径
        System.out.println(file.getParent());
        //获取当前的文件名
        System.out.println(file.getName());
        //获取file对象的文件路径
        System.out.println(file.getPath());
        //获取file文件对象的绝对路径
        System.out.println(file.getAbsoluteFile());
        //获取file文件对象修饰过的文件路径
        System.out.println(file.getCanonicalPath());
        //两则区别: 一个有当前的路径, 一个没有
    }
}