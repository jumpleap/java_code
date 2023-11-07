package io;

import java.io.File;

/**
 * 文件的方法使用
 */
public class Demo5 {
    public static void main(String[] args) {
//        File file = new File("d:/Clinmuyu/aaa");
//        boolean ret = file.mkdir(); //创建单个目录
//        System.out.println(ret);

        //创建多级目录
        File file = new File("d:/Clinmuyu/bbb/ccc/ddd");
        boolean ret = file.mkdirs();
        System.out.println(ret);
    }
}
