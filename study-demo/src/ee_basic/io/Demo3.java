package ee_basic.io;

import java.io.File;
import java.io.IOException;

// File类的常用方法
public class Demo3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 初始化file对象
        File file = new File("d:/test.txt");
        // 删除file对象对应的文件
        // System.out.println(file.delete());

        // 创建file对象对应的文件
        System.out.println(file.createNewFile());

        // 进程结束后,删除file对象对应的文件
        file.deleteOnExit();
        Thread.sleep(5000);
        System.out.println("进程结束");
    }
}
