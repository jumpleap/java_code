package io;

import java.io.File;
import java.io.IOException;

/**
 * 文件的方法使用
 */
public class Demo3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("d:/test.txt");
        System.out.println(file.createNewFile()); //创建文件
        //System.out.println(file.delete()); //删除文件

        file.deleteOnExit(); //进程结束后删除文件
        Thread.sleep(10000);
        System.out.println("进程结束!");
    }
}
