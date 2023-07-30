package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class DisappearNumber {
    /**
     * 法一：哈希表：先存储缺失数的数组的所有值，在把0-n的所有值进行比较，找出缺失的数
     * 时间、空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;

    }

    /**
     * 法二：数学：先把0-n的所有值加起来，然后减去缺失的数组，找到缺失的数
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int total = 0;
        for (int i = 0; i <= nums.length; i++) {
            total += i;
        }

        for (int num : nums) {
            total -= num;
        }
        return total;
    }

    /**
     * 法三：异或：先把0-n的值异或一遍，在异或一遍数组中的值
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int ret = 0;
        for (int i = 1; i <= nums.length; i++) {
            ret ^= i;
        }

        for (int num : nums) {
            ret ^= num;
        }
        return ret;
    }
}