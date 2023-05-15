package leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。
 * 计算并返回该研究者的 h 指数。
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数”，
 * 一名科研人员的 h指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
 * 且其余的 n - h 篇论文每篇被引用次数 不超过 h 次。
 * 如果 h 有多种可能的值，h 指数 是其中最大的那个。
 */
public class HIndex {
    /**
     * 题意理解：如果一个人h指数是10，则说明这个人的n篇论文中被引用的论文篇数是10篇
     * @param args main中的形参
     */
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{1, 2, 41, 23, 1, 44, 5}));
    }

    /**
     * 思路分析：对数组进行排序，然后从后向前遍历，如果数组的元素比h指数，则使h指数++，
     * 一直到数组元素比h指数小跳出循环
     * 时间复杂度：O(nlogN); 空间复杂度：O(1)
     * @param citations 查找h指数的数组
     * @return 返回h指数
     */
    public static int hIndex(int[] citations) {
        //给数组进行排序
        Arrays.sort(citations);

        int h = 0;//h指数设为0
        int len = citations.length - 1;
        int i = 0;

        //从后往前判断citations[len]的值是否大于h指数，大于则h自增
        //一直到不大于h指数的值后跳出循环；i <= len是为了防止数组越界
        while (i <= len && citations[len] > h) {
            h++;
            len--;
        }
        return h;
    }
}
