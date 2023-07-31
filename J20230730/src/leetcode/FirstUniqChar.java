package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {
    /**
     * 法一：Map集合
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param s
     * @return
     */
    public char firstUniqChar1(String s) {
        //建立Map集合
        Map<Character, Integer> map = new HashMap<>();
        //把字符串中的字符和出现的次数记录在Map中
        for (int i = 0; i < s.length(); i++) {
            //第一次出现
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else {
                //若不是第一次出现，使用value记录已经出现的次数，在重新放入到Map中
                int value = map.get(s.charAt(i));
                map.put(s.charAt(i), value + 1);
            }
        }

        //找到字符串中第一个只出现一次的字符
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    /**
     * 法二：哈希数组:建立哈希数组，把字符串中的字符映射到哈希数组中，在把字符串中的字符在哈希数组中寻找等于1的值
     * 时间复杂度：O(n)
     * 空间复杂度：O(1) 建立的是常数个数组
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        int[] array = new int[26];//定义哈希数组

        //把字符串的指映射到哈希数组中
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            array[ch - 'a']++;
        }

        //再次遍历字符串，判断当前的字符是不是第一个只出现的字符
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //判读当前的字符是否是第一个只出现一次的字符
            if (array[ch - 'a'] == 1) {
                return ch;
            }
        }
        //找不到，返回' '
        return ' ';
    }
}