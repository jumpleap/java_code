package leetcode.simply.double_pointer;

// 盛水最多的容器
public class MaxArea {
    /*
        给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
        找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
        返回容器可以储存的最大水量。说明：你不能倾斜容器。
        链接：https://leetcode.cn/problems/container-with-most-water/description/
     */

    /**
     * 双指针 -- 左右双指针
     * 思路分析：定义左右双指针，判断当前左右双指针所围的面积【最小的高度】，那边高度小，则把那边移动，最后获取最大面积
     * 时间复杂度：O(N)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        // 定义双指针
        int left = 0;
        int right = height.length - 1;
        // 最大值
        int max = 0;

        // 相遇退出
        while (left < right) {
            // 临时值，获取当前left和right的面积
            int tmp = 0;

            // 右边小，right--
            if (height[left] > height[right]) {
                tmp = height[right] * (right - left);
                right--;
            } else {
                // 左边小，left++;
                tmp = height[left] * (right - left);
                left++;
            }

            // 获取最大面积
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }
}
