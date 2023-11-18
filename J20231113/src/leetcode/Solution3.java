package leetcode;

import java.util.*;
// 二分查找

public class Solution3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 时间复杂度: O(logN)
     * 空间复杂度: O(1)
     *
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] nums, int target) {
        // 找到数组的左右端点
        int left = 0;
        int right = nums.length - 1;
        // 找到的目标值下标, 没有找到则返回-1
        int index = -1;

        while (left <= right) {
            // 取中值, 且不会溢出
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) { // 小于, 则把left右移到mid+1的位置
                left = mid + 1;
            } else if (nums[mid] > target) { // 大于, 则把right右移到mid-1的位置
                right = mid - 1;
            } else { // 找到了
                index = mid;
                break;
            }
        }
        // 返回下标
        return index;
    }
}