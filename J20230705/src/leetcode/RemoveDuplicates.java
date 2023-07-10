package leetcode;

/*
给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。
nums 的其余元素与 nums 的大小不重要。
返回 k 。
 */
public class RemoveDuplicates {
    /**
     * 思路分析：左右指针，若是left和right的值相同，那么把right右移；若是不相同，则把右指针的值赋给左指针右移一位，右指针右移
     * 时间复杂度：O(n) 空间复杂度：O(1)
     * @param nums 数组
     * @return 返回改变的数组长度
     */
    public int removeDuplicates(int[] nums) {
        //左右指针
        int left = 0;
        int right = 1;

        //判断：右指针的下标要小于数组长度
        while (right < nums.length) {
            //判断左指针的值是否等于右指针
            if (nums[left] != nums[right]) {
                //把右指针的值赋给左指针右移一位，然后右指针右移
                nums[++left] = nums[right++];
            } else {
                //右指针
                right++;
            }
        }
        //返回新的数组长度
        return left + 1;
    }
}