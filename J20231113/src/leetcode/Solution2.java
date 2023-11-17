package leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    /**
     * 思路分析: 哈希表, 哈希表中存储二元组, 第一个对应数组元素, 第二个对应数组下标
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param nums   给定数组
     * @param target 给定目标值
     * @return 返回值
     */
    public int[] twoSum(int[] nums, int target) {
        // 两元组, 第一个Integer -> 数组元素, 第二个Integer -> 下标
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 判断map中是否有元素在map中 + nums[i]  == target
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                // 不存在这个元素, 则把这个元素放入到map中去
                map.put(nums[i], i);
            }
        }
        // 不存在这两个元素, 则返回-1,-1这个二元组
        return new int[]{-1, -1};
    }
}