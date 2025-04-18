package data_structure.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 林沐雨
 * @Date 2025/4/18
 * @Description
 */
public class LeetCode {
    // 杨辉三角：https://leetcode.cn/problems/pascals-triangle/
    public List<List<Integer>> generate(int numRows) {
        // 定义结果集合
        List<List<Integer>> ret = new ArrayList<>();

        // 第一行的值
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        // 把第一行的结果加入到结果集中
        ret.add(firstLine);

        // 从第二行开始，到最后一行
        for (int i = 1; i < numRows; i++) {
            // 申请要加入行的顺序表，用于存储值
            List<Integer> tmp = new ArrayList<>();
            // 第一个和最后一个的值都是1
            tmp.add(1);

            // 获取上一行的顺序表，用于计算tmp应加入的值
            List<Integer> prev = ret.get(i-1);
            // 从1开始，因为我们第一个已经加入了1
            for (int j = 1; j < i; j++) {
                // 计算值：为上一行的左右两个值之和
                int ans = prev.get(j) + prev.get(j-1);
                // 加入到tmp中
                tmp.add(ans);
            }
            tmp.add(1);
            // 把计算好的当前行的值添加到结果集中
            ret.add(tmp);
        }
        // 返回结果集
        return ret;
    }
}
