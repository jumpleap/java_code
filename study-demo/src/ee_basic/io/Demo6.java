package ee_basic.io;

import java.io.File;
import java.io.IOException;

// File类的常用方法
public class Demo6 {
    public static void main(String[] args) throws IOException {
        File src = new File("d:/demo.txt");
        File dest = new File("d:/test.txt");

        // 根据file对象名创建文件
        // System.out.println(src.createNewFile());
        // System.out.println(dest.createNewFile());

        // 删除file对象对应的文件
        // System.out.println(src.delete());
        // System.out.println(dest.delete());

        // 方法要求: 调用方法的file对应文件必须存在, 重命名的file对应文件不存在
        boolean ret = dest.renameTo(src);
        System.out.println(ret);
    }
}
