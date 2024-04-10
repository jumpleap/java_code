package ee_basic.io;

import java.io.File;
import java.io.IOException;

// File类的常用方法
public class Demo1 {
    public static void main(String[] args) throws IOException {
        // 初始化File对象
        File file = new File("./test.txt");
        // 获取file对象上一级路径
        System.out.println(file.getParent());
        // 获取file对象的文件名
        System.out.println(file.getName());
        // 获取file对象的文件路径
        System.out.println(file.getPath());
        // 获取file对象的绝对路径
        System.out.println(file.getAbsoluteFile());
        // 返回file对象修饰后的绝对路径
        System.out.println(file.getCanonicalFile());
        // 两者相差: ./
    }
}
