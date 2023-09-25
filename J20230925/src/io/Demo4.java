package io;

import java.io.File;
import java.util.Arrays;

/**
 * list的使用
 */
public class Demo4 {
    public static void main(String[] args) {
        File file = new File("d:/");
        //统计file对象目录下的所有文件名,若是文件, 返回null
        String[] files = file.list();
        System.out.println(Arrays.toString(files));
    }
}
