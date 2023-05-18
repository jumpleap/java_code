package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 */
public class Generate {
    /**
     * 思路关键：第一个元素和最后一个元素都是1，其他元素是：nums[i][j] = nums[i-1][j] + nums[i-1][j-1]
     * 时间复杂度：O(n^2)；空间复杂度：O(1)
     * @param numRows 杨辉三角的行数
     * @return 返回集合
     */
    public List<List<Integer>> generate(int numRows) {
        //申请集合【底层是二维数组】
        List<List<Integer>> list = new ArrayList<>();
        //第一行
        List<Integer> firstRow = new ArrayList<>();
        //第一行只有1个数：1
        firstRow.add(1);
        //把第一行添加到集合中
        list.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            //剩下的行
            List<Integer> curRow = new ArrayList<>();
            //添加第一个元素
            curRow.add(1);
            //上一行
            List<Integer> preRow = list.get(i - 1);
            for (int j = 1; j < i; j++) {
                //curRow.add(list.get(i-1).get(j) + list.get(i-1).get(j-1));
                //中间的值
                int x = preRow.get(j) + preRow.get(j - 1);
                curRow.add(x);
            }
            //最后一个元素
            curRow.add(1);
            //把curRow添加到集合中
            list.add(curRow);
        }
        return list;
    }
}