package demo;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 */
class Solution {
    /**
     * 思路分析: 左右指针
     * 1) 判断左右指针的那个值小, 以小的为面积计算, 然后和最大面积进行比较, 大于则赋值
     * 2) 左右指针的值那个小, 则那个指针移动
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     *
     * @param height 给定数组
     * @return 返回最大面积
     */
    public int maxArea(int[] height) {
        //定义左右指针
        int left = 0;
        int right = height.length - 1;
        //临时面积
        int maxArea = 0;
        //最大面积
        int tmpArea = 0;

        while (left < right) {
            //判断左右指针的值那边小, 用小的来计算面积
            if (height[left] < height[right]) {
                //左边小, 左边的值当作高来计算面积, 且右移
                tmpArea = (right - left) * height[left];
                left++;
            } else {
                //右边小, 右边的值当作高来计算面积, 且左移
                tmpArea = (right - left) * height[right];
                right--;
            }

            //判断最大面积
            if (tmpArea > maxArea) {
                maxArea = tmpArea;
            }
        }
        return maxArea;
    }
}