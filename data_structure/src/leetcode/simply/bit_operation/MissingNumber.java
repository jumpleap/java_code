package leetcode.simply.bit_operation;

import java.util.Arrays;

// 缺失的数
public class MissingNumber {
    /*
        给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
        https://leetcode.cn/problems/missing-number/description/
     */

    /**
     * 排序 + 比较
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N) -> 快排
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        int len = nums.length;
        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            // 不同时，说明缺失的就是这个数字
            if (nums[i] != i) {
                // 返回缺失的数字
                return i;
            }
        }
        // 跳出循环，说明缺失的是最后一个数字
        return len;
    }

    /**
     * 法二：异或
     * 特点：ans ^ 0 = ans; ans ^ ans = 0;
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int ans = 0;
        // 先用ans和[0, nums.length]的长度进行异或
        for (int i = 0; i <= nums.length; i++) {
            ans ^= i;
        }

        // 再使用ans和数组元素进行异或，即可获得缺失的数
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        // 返回结果
        return ans;
    }
}
