package leetcode;

import java.util.HashSet;
import java.util.Set;
@SuppressWarnings({"all"})
/*
给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 */
public class SingleNumber {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        //异或的性质解决：相同的数异或为0，0和任何数异或为任何数
        int ret = nums[0];

        for (int i = 1; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            //判断nums[i]是否在set中
            if (!set.contains(nums[i])) {
                //若不存在，添加到set中
                set.add(nums[i]);
            } else {
                //存在，则把含有的nums[i]删除
                set.remove(nums[i]);
            }
        }

        for (int i = 0; i < nums[i]; i++) {
            //返回set唯一存在的值
            if (set.contains(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }
}