package ee_basic.io;

import java.io.File;
import java.io.IOException;

// File类的常用方法
public class Demo2 {
    public static void main(String[] args) throws IOException {
        // 初始化file对象
        File file = new File("d:/test.txt");
        // 判断file对象对应的文件是否存在
        System.out.println(file.exists());
        // 判断file对象对应的是不是目录
        System.out.println(file.isDirectory());
        // 判断file对象对应的是不是文件
        System.out.println(file.isFile());

        // 创建file对象对应的文件
        boolean newFile = file.createNewFile();
        System.out.println(newFile);

        // 判断file对象对应的文件是否存在
        System.out.println(file.exists());
        // 判断file对象对应的是不是目录
        System.out.println(file.isDirectory());
        // 判断file对象对应的是不是文件
        System.out.println(file.isFile());
    }
}
