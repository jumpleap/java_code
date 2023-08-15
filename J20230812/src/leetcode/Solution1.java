package leetcode;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可
 */
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        //结束条件：左指针大于右指针
        while (left < right) {
            //判断左右指针的值是否和target相等
            if (nums[left] + nums[right] == target) {
                return new int[]{nums[left], nums[right]};
            } else if (nums[left] + nums[right] > target) {
                //若左右指针的和大于target，则需要右指针左移
                right--;
            } else {
                //若左右指针的和小于target，则需要左指针右移
                left++;
            }
        }
        //没有等于target的和
        return null;
    }
}