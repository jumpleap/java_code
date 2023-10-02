package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 */
class Solution11 {
    /**
     * 排序 + 双指针[需要有三数之和的基础]
     * 时间复杂度: O(n^3)
     * 空间复杂度: O(logN)
     * @param nums 给定数组
     * @param target 目标值
     * @return 返回四数之和的集合
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        //数组排序
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) { //固定第一个数
            for (int j = i + 1; j < len; j++) { //固定第二个数
                int left = j + 1;
                int right = len - 1;
                //获取目标值, 需要强制类型转化, 避免溢出
                long aim = (long) target - nums[i] - nums[j];

                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum > aim) {
                        right--;
                    } else if (sum < aim) {
                        left++;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        //去重,去掉左边和右边重复的元素
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                }

                //给固定的第二个数进行去重
                while (j < len - 1 && nums[j] == nums[j + 1]) j++;
            }

            //给固定的第一个数进行去重
            while (i < len - 1 && nums[i] == nums[i + 1]) i++;
        }
        return ans;
    }
}