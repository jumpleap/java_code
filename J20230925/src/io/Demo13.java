package io;

import java.io.File;
import java.util.Scanner;

/**
 * 扫描指定目录，并找到名称中包含指定字符的所有普通文件（不包含目录），
 * 并且后续询问用户是否要删除该文件
 */
public class Demo13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要扫描的路径:");
        String path = scanner.next();
        File file = new File(path);
        if (!file.isDirectory()) {
            System.out.println("输入的路径有误");
            System.exit(-1);
        }

        System.out.println("请输入要删除文件的关键字:");
        String key = scanner.next();

        searchKey(file, key);
        scanner.close();
    }

    private static void searchKey(File file, String key) {
        //获取当前目录下的所有文件和目录
        File[] files = file.listFiles();
        if (files == null) {
            //files为空,直接返回
            return;
        }

        for (File f : files) {
            if (!f.isDirectory()) {//文件
                isDelete(f, key);
            } else { //目录, 继续进行递归
                searchKey(f, key);
            }
        }
    }

    private static void isDelete(File f, String key) {
        if (!f.getName().contains(key)) {
            //不删除
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("当前文件:" + f.getAbsolutePath() + "是否要删除该文件(y/n):");
        String choice = scanner.next();

        if (choice.equals("y") || choice.equals("Y")) {
            f.delete();
            System.out.println("删除成功!");
        } else {
            System.out.println("取消删除!");
        }
    }
}