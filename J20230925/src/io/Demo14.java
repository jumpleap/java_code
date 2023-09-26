package io;

import java.io.*;
import java.util.Scanner;

/**
 * 文件的复制
 */
public class Demo14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要复制文件的路径:");
        String srcPath = scanner.next();
        File srcFile = new File(srcPath);

        //异常判断, 不是文件或不村子啊
        if (!srcFile.exists() || !srcFile.isFile()) {
            return;
        }

        System.out.println("请输入目标文件的路径:");
        String destPath = scanner.next();
        File destFile = new File(destPath);

        //异常判断
        if (!destFile.exists() || !destFile.isFile()) {
            return;
        }

        fileCopy(srcFile, destFile);
    }

    private static void fileCopy(File srcFile, File destFile) {
        try (InputStream inputStream = new FileInputStream(srcFile)) {
            try (OutputStream outputStream = new FileOutputStream(destFile)) {
                while (true) {
                    byte[] buffer = new byte[1024];
                    //使用input进行读
                    int len = inputStream.read(buffer);

                    if (len == -1) {
                        break;
                    }
                    //使用output进行写
                    outputStream.write(buffer, 0, len);
                }
                //刷新缓冲区
                outputStream.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("复制成功!");
    }
}