package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * 如果存在，返回 true ；否则，返回 false 。
 */
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate1(new int[]{1, 1, 2, 2, 1}, 2));
        System.out.println(containsNearbyDuplicate(new int[]{1, 1, 2, 2, 1}, 2));
    }

    /**
     * 法一：暴力枚举比较
     * 时间复杂度：O(n^2); 空间复杂度：O(1)
     * @param nums 所要求的数组
     * @param k    目标值
     * @return 返回值
     */
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    if (Math.abs(i - j) <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 思路分析：滑动窗口
     * 时间复杂度：O(n); 空间复杂度：O(n)
     * 思路分析：
     * 使用集合存储数组中的值，每次在存储数组值在集合中的时候先判断该值是否在集合中已经拥有，
     * 如果没有，则添加到集合中去，如果有且下标在Math.abs(i-j)<= k的范围内的话，则返回true；
     * 如果集合的长度大于k值的话，则把前面所添加的数组元素删掉【即，集合中只能存储k个值】；
     * 遍历结束后，没有对应符合的条件，则返回false
     * @param nums 数组
     * @param k    目标值
     * @return 返回值
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        //HashSet集合具有元素不重复性和元素无序性
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < len; i++) {
            //判断set中是否有该元素
            if (set.contains(nums[i])) {
                return true;
            }
            //把该元素添加到集合中去
            set.add(nums[i]);

            //集合长度大于k则说明：把添加数组前面的元素删掉
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}