package io;

import java.io.File;

/**
 * renameTo的使用
 */
public class Demo6 {
    public static void main(String[] args) {
        //src -> 源  dest -> 目标
        //注意,重命名需要文件存在
        File srcFile = new File("d:/test.txt");
        File destFile = new File("d:/test2.txt");

        boolean ans = srcFile.renameTo(destFile);
        System.out.println(ans);
    }
}
