package io;

import java.io.File;

/**
 * mkdir和mkdirs的使用
 */
public class Demo5 {
    public static void main(String[] args) {
        File file = new File("d:/java109/aaa");
        //mkdir不能创建多个目录, 需要使用mkdirs
        //boolean ans = file.mkdir();
        boolean ans = file.mkdirs();
        System.out.println(ans);
    }
}
