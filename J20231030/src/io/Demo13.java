package io;

import java.io.File;
import java.util.Scanner;

/**
 * 扫描特定目录中要删除的文件
 */
public class Demo13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //让用户先输入一个要删除文件的目录路径
        System.out.println("请输入要删除的目录路径:");
        String path = scanner.next();
        File file = new File(path);

        if (!file.isDirectory()) {
            System.out.println("这不是一个目录");
            return;
        }

        //让用户输入要删除文件的关键字
        System.out.println("请输入要删除的文件关键字:");
        String word = scanner.next();

        scanDir(file, word);
    }

    //扫描文件的路径
    private static void scanDir(File file, String word) {
        //列出当前路径下的所有文件和目录
        File[] files = file.listFiles();

        //file为空
        if (files == null) {
            //当前目录为空, 直接返回
            return;
        }

        for (File f : files) {
            //加个日志
            System.out.println("当前文件的路径是 " + f.getAbsolutePath());
            if (f.isFile()) {
                judgeWord(f, word);
            } else {
                scanDir(f, word);
            }
        }
    }

    //删除文件的逻辑
    private static void judgeWord(File f, String word) {
        if (!f.getName().contains(word)) {
            //不包含word关键字
            return;
        }
        System.out.println("你确定要删除" + f.getAbsolutePath() + "这个文件吗?(y/n)");
        Scanner scanner = new Scanner(System.in);
        String result = scanner.next();

        if ("y".equals(result) || "Y".equals(result)) {
            f.delete();
            System.out.println("删除完毕!");
        } else {
            System.out.println("取消删除!");
        }
    }
}