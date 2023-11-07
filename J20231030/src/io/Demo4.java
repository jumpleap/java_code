package io;

import java.io.File;
import java.util.Arrays;

/**
 * 文件的方法使用
 */
public class Demo4 {
    public static void main(String[] args) {
        File file = new File("d:/");
        //获取当前目录下的所有文件信息, 该信息使用字符串数组来存储
        String[] files = file.list();
        System.out.println(Arrays.toString(files));
    }
}
