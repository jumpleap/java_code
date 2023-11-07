package io;

import java.io.File;
import java.io.IOException;

/**
 * 文件的方法使用
 */
public class Demo6 {
    public static void main(String[] args) throws IOException {

        //src就是 "源", dest 就散 "模板"
        File srcFile = new File("d:/test.txt");
        System.out.println(srcFile.createNewFile());
        File destFile = new File("d:/dest.txt");

        System.out.println(srcFile.renameTo(destFile));//把目的文件的名字赋给源文件
        System.out.println(srcFile.exists());
        System.out.println(destFile.exists());
    }
}
