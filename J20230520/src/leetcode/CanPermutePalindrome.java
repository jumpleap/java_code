package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 */
public class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        //HashSet中如果不允许有重复的元素
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            //如果已经添加了相同的元素，则把这个元素删掉
            if (!set.add(c)) {
                set.remove(c);
            }
        }
        return set.size() <= 1;
    }
}
