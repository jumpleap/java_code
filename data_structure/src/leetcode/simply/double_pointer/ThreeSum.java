package leetcode.simply.double_pointer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 三数之和
public class ThreeSum {
    /*
        给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
        同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
        注意：答案中不可以包含重复的三元组。
        链接：https://leetcode.cn/problems/3sum/description/
     */

    /**
     * 排序 + 双指针
     * 思路分析：排序 + 双指针 + 去重
     * 时间复杂度：O(N^2) + O(NlogN)【快排时间复杂度】
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 初始化顺序表
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        // 排序
        quickSort(nums);
        int n = nums.length;

        // 固定最小的数
        for (int i = 0; i < n - 1; i++) {
            // 优化，值为正不存在相加为0的结果
            if (nums[i] > 0) break;

            // 定义左右双指针
            int left = i + 1;
            int right = n - 1;
            // 取目标值的相反数，当和target相等，则说明相加为0
            int target = -nums[i];

            // 相遇跳出
            while (left < right) {
                int sum = nums[left] + nums[right];

                // 大于则right--
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    // 小于则left++;
                    left++;
                } else {
                    // 初始化顺序表
                    List<Integer> tmp = new ArrayList<>();
                    // 相加结果为0，记录
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    tmp.add(nums[i]);

                    list.add(tmp);

                    // left后移，right前移
                    left++;
                    right--;

                    // 去重
                    // 判断左边的元素是否有相同的, 和前一个元素进行比较
                    while (left < right && nums[left] == nums[left - 1]) {
                        // 相同，则后移
                        left++;
                    }

                    // 判断右边的元素是否有相同的, 和前一个元素进行比较
                    while (left < right && nums[right] == nums[right + 1]) {
                        // 相同，则前移
                        right--;
                    }
                }

            }

            // 对i去重
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return list;

    }

    /**
     * 法一：暴力枚举: 排序 + 枚举 + 去重 -> 超时
     * 时间复杂度：O(N^3)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        // 数组排序
        quickSort(nums);

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);

                        set.add(tmp);
                    }
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }

    // 手搓快排
    private void quickSort(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    private void quick(int[] arr, int left, int right) {
        if (left >= right)
            return;

        int pivot = partition(arr, left, right);

        quick(arr, left, pivot - 1);
        quick(arr, pivot + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        // 固定值，和下标
        int key = arr[left];
        int tmp = left;

        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }

            while (left < right && arr[left] <= key) {
                left++;
            }

            // 交换
            swap(arr, left, right);
        }

        // 和基准交换
        swap(arr, tmp, left);
        return left;

    }

    // 交换
    private void swap(int[] arr, int left, int right) {
        int val = arr[left];
        arr[left] = arr[right];
        arr[right] = val;
    }
}
