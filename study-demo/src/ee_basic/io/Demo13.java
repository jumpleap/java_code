package ee_basic.io;

import java.io.File;
import java.util.Scanner;

// 综合练习 -- 根据关键字查询, file对象对应文件下的所有文件
public class Demo13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要扫描的路径: ");
        String path = scanner.next();

        // 创建对应的file对象
        File root = new File(path);
        // 若file对象对应的不是目录, 则时间返回
        if (!root.isDirectory()) {
            System.out.println("你输入的路径有误, 请检查后重新输入!");
            return;
        }

        // 让用户输入要查询的关键字
        System.out.println("请输入要删除文件的关键字: ");
        String key = scanner.next();

        // 对file对象的对应目录下的目录和文件进行递归查询, 查询要删除的文件
        isDelete(root, key);
    }

    private static void isDelete(File root, String key) {
        // 列出file对象对应的所有文件和目录
        File[] files = root.listFiles();
        // 说明当前file对象啥都没有
        if (files == null) return;

        for (File file : files) {
            // 当前访问的路径, 即日志
            System.out.println("当前扫描的路径:" + file.getAbsolutePath());
            // 判断当前file对象对应的是不是一个文件
            if(file.isFile()) {
                checkDelete(file, key);
            } else if(file.isDirectory()) {
                // 是目录
                isDelete(file, key);
            } else {
                // 既不是文件, 也不是目录, 说明不存在
                break;
            }
        }
    }

    private static void checkDelete(File file, String key) {
        // 不包含关键字, 直接返回
        if (!file.getName().contains(key)) return;

        // 删除操作
        System.out.println("当前的文件为: " + file.getAbsolutePath() + ", 确定是否需要删除?(y/n)");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        // 进行判断, 是否确定要删除
        if (choice.equals("y") || choice.equals("Y")) {
            // 删除
            file.delete();
            System.out.println("删除完毕!");
        } else {
            System.out.println("取消删除!");
        }
    }
}
