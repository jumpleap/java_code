package ee_basic.io;

import java.io.*;

// 把字节流转为字符流, 然后写数据
public class Demo12 {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("d:/test.txt", true)) {
            // 把字节流转为字符流
            PrintWriter printWriter = new PrintWriter(outputStream);
            // 写数据
            printWriter.println("hello Spring");
            // 刷新缓冲区, 防止读不到数据
            printWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
