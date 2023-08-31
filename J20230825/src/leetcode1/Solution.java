package leetcode1;

/**
 * 输入一个递增排序的数组和一个数字s，
 * 在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
class Solution {
    /**
     * 思路分析：左右指针。左指针指向数组首位置，右指针指向数组最后一个位置；
     * 若左右指针值之和大于要查找的目标值，则说明右边元素值大，让右指针左移；
     * 若左右指针值之和小于要查找的目标值，则说明左边元素值小，让左指针右移；
     * 若左右指针值之和等于要查找的目标值，返回这两个值
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums   给定的递增数组
     * @param target 给定的目标值
     * @return 返回值之和为target的数组
     */
    public int[] twoSum(int[] nums, int target) {
        //定义左右指针
        int left = 0;
        int right = nums.length - 1;

        //左右指针相遇后跳出循环
        while (left < right) {
            //左右指针值之和刚好为目标值
            if (nums[left] + nums[right] == target) {
                return new int[]{nums[left], nums[right]};
            } else if (nums[left] + nums[right] > target) {
                //左右指针值之和大于目标值
                right--;
            } else {
                //左右指针值之和小于目标值
                left++;
            }
        }
        //若循环跳出后则说明没有和为s的两个数组元素
        return new int[]{-1, -1};
    }
}