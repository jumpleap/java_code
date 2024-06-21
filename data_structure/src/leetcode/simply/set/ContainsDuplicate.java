package leetcode.simply.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 存在重复元素
public class ContainsDuplicate {
    /*
        给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
        https://leetcode.cn/problems/contains-duplicate/
     */

    /**
     * 哈希表
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        // 定义哈希表
        Set<Integer> ans = new HashSet<>();
        // 先添加第一个数
        ans.add(nums[0]);

        // 从第二个数开始进行判断
        for (int i = 1; i < nums.length; i++) {
            // 判断是否在哈希表中存在，存在返回true，不存在返回false
            if (ans.contains(nums[i])) return true;
            else ans.add(nums[i]);
        }
        return false;
    }


    /**
     * 排序， 比较
     * 时间复杂度：O(N)
     * 空间复杂度：O(logN) -> 快排的深度
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        // 使用快排进行排序，自己写的超出时间限制【未优化】
        // quickSort(nums, 0, nums.length - 1);
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            // 说明有两个相同的数
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left > right) return;

        // 获取基准
        int pivot = partition(nums, left, right);
        // 继续对基准左侧继续递归排序
        quickSort(nums, left, pivot - 1);
        // 对右半部分进行递归排序
        quickSort(nums, pivot + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int key = nums[left];

        while (left < right) {
            // 从右边找比基准小的
            while (left < right && nums[right] > key) {
                right--;
            }
            // 填坑
            nums[left] = nums[right];

            // 从左边找比基准大
            while (left < right && nums[left] <= key) {
                left++;
            }
            // 填坑
            nums[right] = nums[left];
        }
        // 填最后一个坑，把固定的值填到这个坑中
        nums[left] = key;
        return left;
    }
}
