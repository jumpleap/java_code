package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution4 {
    /**
     * 思路分析: 双指针
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(N)
     *
     * @param nums 给定数组
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