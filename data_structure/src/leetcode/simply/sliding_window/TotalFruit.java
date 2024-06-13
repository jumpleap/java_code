package leetcode.simply.sliding_window;

import java.util.HashMap;
import java.util.Map;

// 水果成篮
public class TotalFruit {
    /*
        你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，
        其中 fruits[i] 是第 i 棵树上的水果 种类 。
        你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
        你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
        你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。
        采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
        一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
        给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
        https://leetcode.cn/problems/fruit-into-baskets/description/
     */

    /**
     * 滑动窗口
     * 转为思路：求k种数字对应的最长子数组
     * 思路：
     *      1.left = 0, right = 0, max = 0, 定义哈希表
     *      2.进窗口，把right下标对应的值及其数量入到哈希表中，若第一次出现，则数量为1
     *      3.判断，判断当前的水果种类是否大于2，大于2则出窗口
     *          获取left下标对应的值，把left下标对应值及其数量-1后放到哈希表中
     *          当right对应值的数量为0，则移除该元素，left自增
     *      4.更新结果，获取最多的水果数量
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        // 第一个Integer记录水果种类，第二个Integer记录水果种类的数量
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int max = 0;

        while (right < fruits.length) {
            // 进窗口
            int in = fruits[right];
            // 获取当前水果种类及其数量，放到哈希表中
            map.put(in, map.getOrDefault(in, 0) + 1);

            // 判断，当种类大于2
            while (map.size() > 2) {
                // 出窗口
                int out = fruits[left];
                // 把水果种类数量-1后重新放到哈希表中
                map.put(out, map.get(out) - 1);
                // 当-1后的水果种类数量为0，则移除当前元素
                if (map.get(out) == 0) map.remove(out);
                left++;
            }

            // 更新结果
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
