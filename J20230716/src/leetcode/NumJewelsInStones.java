package leetcode;

import java.util.Set;
import java.util.TreeSet;

/*
 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。
 stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 */
public class NumJewelsInStones {
    /**
     * 思路分析：把宝石加入到Set中与石头进行比较，若是宝石，则数量自增
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param jewels 宝石
     * @param stones 石头
     * @return 返回宝石的数目
     */
    public int numJewelsInStones(String jewels, String stones) {
        //Set<Character> set = new HashSet<>();
        Set<Character> set = new TreeSet<>();
        //把宝石加入到set中
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        int count = 0;
        //宝石和石头进行比较，若是宝石，则count++
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
