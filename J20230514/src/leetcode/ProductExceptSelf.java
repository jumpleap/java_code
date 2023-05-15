package leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    /**
     * 思路分析：使用left数组计算左边的乘积；使用right数组计算右边的乘积，最后把两个数组对应的下标进行相乘
     * 左边界：left[0] = 1; 右边界：right[0] = 1【左右边界是为了得到最后一个/第一个数的值】
     * 时间复杂度：O(n); 空间复杂度：O(n)
     * @param nums 需要使用的数组
     * @return 返回结果数组
     */
    public static int[] productExceptSelf1(int[] nums) {
        //左数组：用于计算nums[i]左边的乘积
        int[] left = new int[nums.length];
        //右数组：用于计算nums[i]右边的乘积
        int[] right = new int[nums.length];

        left[0] = 1;//设为1，因为1乘任何数为它本身
        for (int i = 1; i < nums.length; i++) {
            //累乘nums[i]左边的值
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[nums.length - 1] = 1;//右数组的最后一个下标设为1
        for (int i = nums.length - 1; i > 0; i--) {
            //累乘nums[i]右边的值
            right[i - 1] = right[i] * nums[i];
        }

        //最后左右相乘即为最后的答案
        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }

    /**
     * 思路分析：使用ret[i] = nums[i-1] * ret[i-1];进行nums[i]左边的累乘，
     * 使用right作为nums[i]的有边界，然后让right累乘，在和ret[i]的值进行相乘得到结果
     * 时间复杂度：O(n); 空间复杂度：O(1)
     * @param nums 需要使用的数组
     * @return 返回结果数组
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];

        //计算nums[i]左边的乘积
        ret[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ret[i] = nums[i - 1] * ret[i - 1];
        }

        //计算nums[i]右边的乘积，并把之前的乘积乘上
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            //边界处理，最右边的值设为1
            ret[i] = ret[i] * right;
            //使用right累乘
            right *= nums[i];
        }

        return ret;
    }
}