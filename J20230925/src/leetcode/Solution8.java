package leetcode;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
class Solution8 {
    /**
     * 最难思考的地方就是: 如何获取自己的下标,然后再走当前下标的步数
     * 思路分析: 贪心
     * 获取每个下标的距离和当前下标值的和, 与最远可到达距离进行比较, 若是大于最远可到达距离, 更新.
     * 若最远可到达距离大于等于数组长度 -1, 那么返回true
     * 遍历完数组后,没有到达数组的最后一个元素, 返回false
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param nums 给定数组
     * @return 是否可到达数组最后一个元素
     */
    public boolean canJump(int[] nums) {
        int distance = 0;
        for (int i = 0; i < nums.length; i++) {
            //若i在最远可到达距离内
            if (i <= distance) {
                //获取最远可达到距离
                distance = Math.max(distance, i + nums[i]);

                //若最远可达到距离已经超过或等于数组长度,那么就说明可以到达最后一个元素
                if (distance >= nums.length - 1) {
                    return true;
                }
            }
        }
        //无法到达最后一个元素
        return false;
    }
}