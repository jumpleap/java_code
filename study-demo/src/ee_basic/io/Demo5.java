package ee_basic.io;

import java.io.File;

// File类的常用方法
public class Demo5 {
    public static void main(String[] args) {
        File file = new File("d:/java109/aaa/bbb");
        // 根据file对象创建一级目录
        boolean mkdir = file.mkdir();
        System.out.println(mkdir);

        // 根据file对象创建多级目录
        boolean mkdirs = file.mkdirs();
        System.out.println(mkdirs);
    }
}
