package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，
 * 使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
 */
class Solution12 {
    /**
     * 思路分析: 排序 + 双指针
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(N)
     * @param nums 给定数组
     * @return 返回集合
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        //排序
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) { //固定第一个数
            //定义左右指针
            int left = i + 1;
            int right = len - 1;
            //目标值
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    //和模目标值相等那么就直接放入到集合中
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    //去重
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }

            //去重
            while (i < len - 1 && nums[i] == nums[i + 1]) i++;
        }
        return ans;
    }
}