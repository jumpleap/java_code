package leetcode.simply.double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 四数之和
public class FourSum {
    /*
        给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
        请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
        （若两个四元组元素一一对应，则认为两个四元组重复）：
        0 <= a, b, c, d < n
        a、b、c 和 d 互不相同
        nums[a] + nums[b] + nums[c] + nums[d] == target
        你可以按 任意顺序 返回答案 。
        链接：https://leetcode.cn/problems/4sum/
     */

    /**
     * 排序 + 双指针 ==> “先固定一个数，再使用三数之和的思想”
     * 时间复杂度：O(N^3)
     * 空间复杂度：O(N)
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        // 排序
        Arrays.sort(nums);
        int n = nums.length;

        int i = 0;
        // 先固定一个数
        while (i < n - 1) {

            // 三数之和思想
            // 固定一个数
            int j = i + 1;
            while (j < n - 1) {
                // 定义双指针
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    // 会越界
                    long val = (long) nums[left] + nums[right] + nums[j] + nums[i];
                    if (val < target) {
                        left++;
                    } else if (val > target) {
                        right--;
                    } else if (val == target) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        // 去重一：对left 和 right 进行去重
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                }
                // 去重二：对j进行去重
                j++;
                while (j < n && nums[j] == nums[j - 1]) j++;
            }

            // 去重三：对i进行去重
            i++;
            while (i < n && nums[i] == nums[i - 1]) i++;
        }
        // 返回结果
        return ret;
    }
}
