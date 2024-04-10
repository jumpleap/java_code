package ee_basic.io;

import java.io.File;
import java.util.Arrays;

// File类的常用方法
public class Demo4 {
    public static void main(String[] args) {
        // 初始化file对象
        File file = new File("d:/");
        // 把file对象对应的文件名或目录名全部放到字符串数组中
        // 展示file对象下的所有文件目录
        String[] list = file.list();
        // 打印
        System.out.println(Arrays.toString(list));

        // 获取file对象对应的所有文件或目录, 把这些文件或目录使用对象表示
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f.getName() + " ");
        }
    }
}