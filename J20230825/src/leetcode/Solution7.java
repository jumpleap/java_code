package leetcode;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 */
class Solution7 {
    /**
     * 思路分析：左右指针。给数组排序，数组有序后，固定数组的最大值【最后一个值】，定义左右指针。
     * 左指针指向数组首元素，右指针指向固定最大值的前一个元素
     * 若左右指针值之和大于固定的最大值，说明左右指针的区间内均是有效的三角形，计算有效三角形的个数后，右指针自减
     * 若左右指针值之和小于固定的最大值，说明左右指针的区间内没有有效的三角形，让左指针右移
     * 时间复杂度：O(n^2)【排序 nlogN + n^2】
     * 空间复杂度：O(1)
     * @param nums 给定的数组
     * @return 返回有效三角形的个数
     */
    public int triangleNumber(int[] nums) {
        //数组排序
        Arrays.sort(nums);

        //数组长度
        int len = nums.length - 1;
        //计算有效三角形的个数
        int count = 0;

        //每次循环前先固定好最大的一个数，构成三角形必须要有三条边
        for (int i = len; i >= 2; i--) {
            //定义左右指针
            int left = 0;
            int right = i - 1;

            //在左右指针的范围内查找有效的三角形个数
            while (left < right) {
                //若左右指针的值大于固定的最大值
                if (nums[left] + nums[right] > nums[i]) {
                    //则左右指针的范围均是有效的三角形
                    count += right - left;
                    //让右指针自减
                    right--;
                } else {
                    //反之，左指针自增
                    left++;
                }
            }
        }
        //返回有效的三角形个数
        return count;
    }
}