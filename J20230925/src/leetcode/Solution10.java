package leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。
 * 计算并返回该研究者的 h 指数。
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
 * 并且每篇论文 至少 被引用 h 次。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 */

class Solution10 {
    /**
     * 题目理解：如果一个人h指数是10，则说明这个人的n篇论文中被引用的论文篇数是10篇
     * 思路分析: 排序后计数, 从后往前计数
     * 若是citations[i] > h, 则h++;
     * 时间复杂度: O(NlogN)
     * 空间复杂度: O(logN)
     * @param citations 给定数组
     * @return 返回h指数
     */
    public int hIndex(int[] citations) {
        //给数组进行排序
        Arrays.sort(citations);

        int h = 0;//h指数设为0
        int len = citations.length - 1;

        //从后往前判断citations[len]的值是否大于h指数，大于则h自增
        //一直到不大于h指数的值后跳出循环；i <= len是为了防止数组越界
        while (len >= 0 && citations[len] > h) {
            h++;
            len--;
        }
        return h;
    }
}