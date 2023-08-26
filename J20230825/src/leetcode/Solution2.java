package leetcode;

/**
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 */
class Solution2 {
    /**
     * 思路分析：左右指针。左指针指向数组首下标，右指针指向数组的最后一个位置。
     * 获取左右指针的和，然后和目标值进行比较。大于，则右指针左移；小于，则左指针右移，相等则返回其值位置
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param numbers 给定数组
     * @param target  目标值
     * @return 返回下标
     */
    public int[] twoSum(int[] numbers, int target) {
        //定义左右指针
        int left = 0;
        int right = numbers.length - 1;

        //左右指针相遇后退出循环
        while (left < right) {
            //左右指针之和
            int ret = numbers[left] + numbers[right];

            if (ret > target) { //若和大于目标值，则右指针左移
                right--;
            } else if (ret < target) { //若和小于目标值，则左指针右移
                left++;
            } else { //返回对应的下标值
                return new int[]{left + 1, right + 1};
            }
        }
        //不存在的情况
        return new int[]{-1, -1};
    }
}