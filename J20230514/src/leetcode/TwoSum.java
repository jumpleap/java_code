package leetcode;

/**
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，
 * 请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，
 * 则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 */
public class TwoSum {
    /**
     * 思路分析：左右指针
     * 时间复杂度：O(n)；空间复杂度：O(1)
     * @param numbers 查找数组
     * @param target 目标值
     * @return 返回找到的下标
     */
    public int[] twoSum(int[] numbers, int target) {
        //左右指针
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            //判断左值和右值的和与target的比较
            if (numbers[left] + numbers[right] > target) {
                right--;//右值左移
            } else if (numbers[left] + numbers[right] < target) {
                left++;//左值右移
            } else {
                break;//相等则跳出循环
            }
        }
        //因为下标从1开始，所以需要+1
        return new int[]{left + 1, right + 1};
    }
}