package leetcode;

/*
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。
 */

import java.util.HashMap;
import java.util.Map;

class Solution5 {
    /**
     * 法一：暴力枚举 -> 双重循环找到数组中两个值相加为target的值，最后返回两个值的下标
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param nums 给定的数组
     * @param target 给定的目标值
     * @return 返回两个下标值为target的数组
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 法二：哈希表 -> 建立哈希表，把值和下标映射到哈希表中，每映射一个nums[i]时，判断target - nums[i]是否在哈希表中存在
     * 若存在，则把当前nums[i]的下标和target - nums[i]的下标返回；若不存在，则把该值映射到哈希表中
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums 给定的数组
     * @param target 给定的目标值
     * @return 返回两个下标值为target的数组
     */
    public int[] twoSum(int[] nums, int target) {
        //申请哈希表，建立映射关系(值，下标)
        Map<Integer, Integer> map = new HashMap<>();

        //遍历数组,构建下标和值的映射关系
        for (int i = 0; i < nums.length; i++) {
            //若target-nums[i]的值在map中，则说明存在两个值相加为target
            if (map.containsKey(target - nums[i])) {
                //返回这两个值的下标
                return new int[]{map.get(target - nums[i]), i};
            } else {
                //不存在的值，则放入到map中
                map.put(nums[i], i);
            }
        }
        //不存在的返回
        return new int[]{-1, -1};
    }
}