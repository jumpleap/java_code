package leetcode2;

import java.util.Arrays;

/*
给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
class Solution3 {
    /**
     * 法一：排序后取中间值
     * 时间复杂度：Olog(n)
     * 空间复杂度：O(1)
     * @param nums 给定的数组
     * @return 返回多数元素
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);//排序
        //取中值
        return nums[nums.length / 2];
    }


    /**
     * 法二：消消乐，相同的数则增加，不同的数抵消
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums 给定的数组
     * @return 返回多数元素
     */
    public int majorityElement(int[] nums) {
        int length = nums.length;
        int target = nums[0];//多数元素
        int count = 1;//计算相同的元素

        //遍历数组
        for (int i = 1; i < length; i++) {
            //相同则count++
            if (target == nums[i]) {
                count++;
            } else {
                //count为0，则说明target不是多数元素，更换
                if (count == 0) {
                    target = nums[i];
                    count = 1;
                } else {
                    //count自减
                    count--;
                }
            }
        }
        //最后返回的数是多数元素
        return target;
    }
}