package leetcode;

/**
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
 * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 */
class Solution3 {
    /**
     * 思路分析: 双指针.
     * 右指针遍历整个数组, 左指针用于筛选重复的数据
     * 遇到重复的数据, 那么让右指针右移; 没有遇到重复的数据, 那么左指针先左移, 在把右指针的值赋给左指针
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param nums 给定数组
     * @return 返回数组的新长度
     */
    public int removeDuplicates1(int[] nums) {
        //左右指针
        int left = 0;
        int right = 1;
        //数组长度
        int len = nums.length;

        //遍历数组
        while (right < len) {
            //左右指针的值不相等,则把right的值赋给left++
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
            right++;
        }
        //left是下标, 数组长度需要+1
        return left + 1;
    }

    /**
     * 思路分析: 保留k位重复的数字, 模板
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param nums 给定数组
     * @return 返回数组的新下标
     */
    public int removeDuplicates(int[] nums) {
        return remove(nums, 1);
    }

    private int remove(int[] nums, int k) {
        //记录数组新的下标
        int index = 0;

        for (int num : nums) {
            //保留k为相同的值, 剩下的值也需要保留k位
            if (index < k || nums[index - k] != num) {
                nums[index++] = num;
            }
        }
        //返回数组的新长度
        return index;
    }
}