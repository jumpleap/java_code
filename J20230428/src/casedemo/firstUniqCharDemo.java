package casedemo;

import java.util.Scanner;
@SuppressWarnings({"all"})

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 */
public class firstUniqCharDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        while(scanner.hasNext()) {
            str = scanner.next();
            int ret = firstUniqChar(str);
            System.out.println(ret);
        }
    }

    /**
     * 查找第一个不重复的字符
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        int[] hash = new int[26];

        //映射存储在数组中
        for(char c: arr) {
            hash[c - 'a']++;
        }

        //判断第一次出现的不重复的字符
        for(int i=0; i<arr.length; i++) {
            if(hash[arr[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}