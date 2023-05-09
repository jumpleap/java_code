package leetcode;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 12)));
    }

    /**
     * 找出数组中两个下标对应值等于target的值
     * @param nums   数组
     * @param target 目标值
     * @return 返回对应下标
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
