package leetcode;

import java.util.Stack;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 */
public class Exchange {
    /**
     * 法一：使用栈，先把偶数放入栈中，再把奇数放入栈中，最后出栈到数组中
     * 时间、空间复杂度：O(n)
     * @param nums 给定数组
     * @return 返回整理后的数组
     */
    public int[] exchange1(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        //把偶数放入当栈中
        for (int num : nums) {
            if (num % 2 == 0) {
                stack.push(num);
            }
        }

        //把奇数放入到栈中
        for (int num : nums) {
            if (num % 2 == 1) {
                stack.push(num);
            }
        }

        int index = 0;
        //把栈中的数据重新放入到nums数组中
        while (!stack.empty()) {
            nums[index++] = stack.pop();
        }
        return nums;
    }

    /**
     * 法二：快排思想（首尾指针）：left指针从前向后找偶数，right指针从后向前找奇数，然后交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums 给定数组
     * @return 返回整理后的数组
     */
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (nums[left] % 2 == 1 && left < right) {
                left++;
            }
            //找到偶数了

            while (nums[right] % 2 == 0 && left < right) {
                right--;
            }
            //找到奇数了

            //交换位置
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }

        return nums;
    }
}