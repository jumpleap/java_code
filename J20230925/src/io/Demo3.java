package io;

import java.io.File;

/**
 * 文件方法的基本使用
 */

public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        File file = new File("d:/test.txt");
        //boolean ans = file.delete();
        //System.out.println(ans);

        //在jvm运行结束后才会删除
        file.deleteOnExit();
        Thread.sleep(3000);
        System.out.println("进程结束");
    }
}