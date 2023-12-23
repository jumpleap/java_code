package data_structure.array;

import java.util.ArrayList;
import java.util.List;

/*
给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */

class Solution {
    /**
     * 思路分析: 第一行只有一个元素1, 其他每行的首尾元素都是1, 中间的值为上一行的左右元素之和
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(N)
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        // 定义顺序表
        List<List<Integer>> list = new ArrayList<>();
        // 定义第一行
        List<Integer> first = new ArrayList<>();
        first.add(1);
        // 把第一行添加到顺序表中
        list.add(first);

        // 从第二行开始添加
        for (int i = 1; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            // 添加首1
            tmp.add(1);

            // 从第三行开始进行添加
            for (int j = 1; j < i; j++) {
                // 前一行的前一个元素和当前元素之和
                int ret = list.get(i - 1).get(j - 1) + list.get(i - 1).get(j);
                tmp.add(ret);
            }
            // 添加尾1
            tmp.add(1);

            // 把当前的这一行添加到顺序表中
            list.add(tmp);
        }
        // 返回顺序表
        return list;
    }
}