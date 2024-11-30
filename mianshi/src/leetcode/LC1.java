package leetcode;

import java.util.Arrays;

public class LC1 {
    public int removeElement(int[] nums, int val) {
        // 记录不同元素的个数 & 把与不同val的值写入到nums数组中
        int index = 0;
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 不想同的值重新写入到nums中
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        // 返回结果
        return index;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 获取nums1的长度
        int len = nums1.length - 1;
        // 让m和n自减到对应数组最后一位的位置
        m--;
        n--;

        // 因为是非递减顺序，比较nums1和nums2中的值，谁大谁放在nums1的最后面
        while (m >= 0 && n >= 0) {
            // 比较两个数组的最后一个数字谁大，谁大谁放在最后
            if (nums1[m] > nums2[n]) {
                nums1[len] = nums1[m];
                m--;
            } else {
                nums1[len] = nums2[n];
                n--;
            }
            len--;
        }

        // m对应的nums1数组中还有值
        while (m >= 0) {
            nums1[len--] = nums1[m--];
        }

        // n对应的nums2数组中还有值
        while (n >= 0) {
            nums1[len--] = nums2[n--];
        }
    }

    public int removeDuplicates(int[] nums) {
        // 定义双指针
        int left = 0;
        int right = 1;

        while (right < nums.length) {
            // 遍历完相同的值，right出循环的时候是指向不相同的值
            while (right < nums.length && nums[right] == nums[left]) {
                right++;
            }
            // 特殊情况：都是相同数字 & 后面都是相同的值的情况
            if (right < nums.length) {
                nums[++left] = nums[right];
            }
            // 当前值已经赋给left了，让right指向下一个
            right++;
        }

        // 因为left从0开始，所以最终结果要+1
        return left + 1;
    }

    public int removeDuplicatesII(int[] nums) {
        // 数组中的1号位置与2号位置元素不必删除
        int count = 2;

        // 从2号下标开始遍历
        for (int i = 2; i < nums.length; i++) {
            // 若是当前下标的值和count-2下标的值不相等
            // 直接把当前下标的值映射到count下标的位置上,并使count下标自增
            if (nums[i] != nums[count - 2]) {
                nums[count++] = nums[i];
            }
        }
        return count;

    }

    // 排序
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }

    public int majorityElement(int[] nums) {
        // 计数器，用来获取计算元素最多的那个值
        int count = 1;
        // 结果，先置为数组第一个元素
        int ret = nums[0];

        // 遍历，查找多数元素
        for (int i = 1; i < nums.length; i++) {
            // 比较，判断当前元素是否和这个元素相等，相等即count自增
            // 不相等，则count自减，若count为0，那么重置多数元素与count
            if (ret == nums[i]) {
                count++;
            } else if (count == 0) {
                ret = nums[i];
                count = 1;
            } else {
                count--;
            }
        }
        // 返回结果
        return ret;
    }
}
