package leetcode1;

import java.util.Stack;

class Solution1 {
    /**
     * 法一：栈：遍历数组，把偶数先放入到栈中，再把奇数放入到栈中，最后取出栈中元素
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums 给定的数组
     * @return 返回交换后的数组
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
     * 法二：双职责：左指针指向数组首元素，右指针指向数组尾元素
     * 左指针找到偶数后停止，右指针找到奇数后停止，交换，当左右指针相遇后跳出循环
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums 给定的数组
     * @return 返回交换后的数组
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