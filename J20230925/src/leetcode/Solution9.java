package leetcode;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 */
class Solution9 {
    /**
     * 思路分析: 本题的难点是如何思考怎么才能获取最少步数到最后一个元素
     * 解决: 设置边界值, 当下标值和边界值相同的时候, 那么让步数+1, 且更新最远可到达的距离
     * 获取最远可到达的距离: maxDistance = Math.max(maxDistance, i + nums[i];
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param nums 给定数组
     * @return 返回最少步数
     */
    public int jump(int[] nums) {
        int len = nums.length - 1; //数组长度
        int step = 0; //跳到最后一个元素的步数
        int maxDistance = 0; //最远可到达距离
        int border = 0; //边界

        for (int i = 0; i < len; i++) {
            //获取最远可到达距离
            maxDistance = Math.max(maxDistance, i + nums[i]);

            //i和边界值相同
            if (i == border) {
                //更新边界
                border = maxDistance;
                //步数增加
                step++;
            }
        }
        return step;
    }
}