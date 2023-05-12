package leetcode;

public class Jump {
    public static void main(String[] args) {

    }

    /**
     * 贪心
     * 时间复杂度：O(n)；空间复杂度：O(1)
     * @param nums 数组
     * @return 返回跳的最少步数
     */
    public static int jump(int[] nums) {
        int len = nums.length - 1;//数组长度
        int steps = 0;//跳几步
        int maxPosition = 0;//最大距离
        int end = 0;//边界

        for (int i = 0; i < len; i++) {
            //得到当前下标中可跳到的最大的距离：[0-end]之间的最大距离
            maxPosition = Math.max(maxPosition, i + nums[i]);

            //每次到达边界，均需要更新最大距离
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
