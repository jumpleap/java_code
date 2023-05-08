package blog;

import java.util.Scanner;

public class StringBufferDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "";

        //多组输入
        while (scanner.hasNext()) {
            str = scanner.next();
            System.out.println(splitString(str));
        }
    }

    /**
     * 把价格分割
     * @param str 接收的值
     * @return 返回字符串
     */
    private static String splitString(String str) {
        //转化为StringBuffer
        StringBuffer s = new StringBuffer(str);
        //长度
        int len = s.lastIndexOf(".");
        //每三位进行分割
        for (int i = len - 3; i > 0; i -= 3) {
            s.insert(i, ",");
        }
        //返回字符串
        return s.toString();
    }
}