package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */

class Solution5 {
    /**
     * 思路分析: 模拟, 重点: nums[i][j] = nums[i-1][j] + nums[i-1][j-1]
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     * @param numRows 给定的行数
     * @return 返回杨辉三角
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        //放第一行的元素
        List<Integer> row = new ArrayList<>();
        row.add(1);
        ret.add(row);

        //从第二行开始,继续放元素
        for (int i = 1; i < numRows; i++) {
            //当前行
            List<Integer> cur = new ArrayList<>();
            //放第一个元素
            cur.add(1);
            //获取当前行的前一行
            List<Integer> prev = ret.get(i - 1);
            //放中间元素,从第二个元素开始放,放到i-1个元素的位置
            for (int j = 1; j < i; j++) {
                //获取当前行左上方和右上方的数之和
                int x = prev.get(j) + prev.get(j - 1);
                cur.add(x);
            }
            //放最后一个元素
            cur.add(1);
            //把当前行放入到ret中
            ret.add(cur);
        }
        return ret;
    }
}