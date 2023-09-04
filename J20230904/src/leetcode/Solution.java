package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，
 * 判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
class Solution {
    /**
     * 思路分析：排序 + 左右指针。先给数组进行排序，然后固定最小的值，然后往最小的值的右边范围内定义左右指针。
     * 把固定值的相反数设置为目标值，获取左右指针的和；
     * 若左右指针的和小于目标值，则左指针右移；若大于目标值，则右指针左移；
     * 若和目标值相等，那么则把改组的数据添加到list的集合中，然后缩小左右指针的范围【left++,right--】,
     * 然后判断当前的左指针的值是否和前一个值相同，相同则自增【左指针去重】
     * 判断当前右指针的值是否和后一个值相同，相同则自减【右指针左移】
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(logN) -> 快排所消耗的空间
     * @param nums 给定的数组
     * @return 返回集合
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        int len = nums.length;

        //每次均需要固定最小的值
        for (int i = 0; i < len; i++) {
            //左右指针
            int left = i + 1;
            int right = len - 1;
            //目标值
            int target = -nums[i];

            while (left < right) {
                //获取left和right下标值的和
                int sum = nums[left] + nums[right];

                if (sum > target) { //sum的值大于目标值
                    right--;
                } else if (sum < target) { //sum的值小于目标值
                    left++;
                } else {
                    //添加到新的list中去
                    list.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right])));
                    //List<Integer> tmp = new ArrayList<>();
                    //tmp.add(nums[i]);
                    //tmp.add(nums[left]);
                    //tmp.add(nums[right]);
                    //list.add(tmp);

                    //找到一组值后，需要缩小左右区间的范围
                    left++;
                    right--;

                    //去重和left下标相同的值
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    //去重和right下标相同的值
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }

            //去重和当前下标i相同的值
            while (i < len - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return list;
    }
}