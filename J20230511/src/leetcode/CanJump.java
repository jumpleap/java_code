package leetcode;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
public class CanJump {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{1, 2, 3, 4, 5}));
    }

    /**
     * 贪心
     * 时间复杂度：O(n)； 空间复杂度：O(1)
     * 思路分析：最大跳跃长度会包含前面的长度，我们需要每次更新最大跳跃长度，
     * 跳跃长度更新后和数组长度比较，查看数组长度是否被包含在最大跳跃长度中
     *
     * @param nums 跳跃的数组
     * @return 返回布尔值
     */
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        int distance = 0;//跳的最大距离，最大距离会覆盖前面的距离

        for (int i = 0; i < len; i++) {
            if (i <= distance) {
                //更新distance的最大距离
                distance = Math.max(distance, i + nums[i]);
            }

            //使用distance和数组长度进行比较，查看是否覆盖了数组长度
            if (distance >= len - 1) {
                return true;
            }
        }
        return false;
    }
}