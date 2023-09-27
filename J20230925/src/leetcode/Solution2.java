package leetcode;

import java.util.Arrays;

class Solution2 {
    /**
     * 思路分析: 排序取中值
     * 时间复杂度: O(NlogN)
     * 空间复杂度: O(logN)
     * @param nums 给定数组
     * @return 返回多数元素值
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 思路分析: 摩尔投票法
     * 1) 遍历数组, 定义target值, count值, 若遇到和target相同的值, 则count自增;
     * 2) 若count为0, 则更换target值, 重置count值
     * 3)若数组值不等于target和count不为0, count自减
     * @param nums 给定数组
     * @return 返回多数元素
     */
    public int majorityElement(int[] nums) {
        //计数
        int count = 1;
        //多数元素值
        int target = nums[0];

        //遍历数组
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == target) { //值相同, 则count自增
                count++;
            } else if (count == 0) { //count为0,则替换多数元素值
                target = nums[i];
                count = 1;
            } else { //不相同,则count自减
                count--;
            }
        }
        //返回多数元素
        return target;
    }
}