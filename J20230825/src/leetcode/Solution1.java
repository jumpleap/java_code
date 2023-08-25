package leetcode;

class Solution1 {
    /**
     * 思路分析：最大水位值：长*宽。定义左右指针，左指针指向数组首元素，右指针指向数组末尾元素
     * 初始化最大水位值为-1，获取左右指针的水位值，若大于最大水位值则更新为最大水位值，左右指针那个水位低则那个移动
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param height 给定水位数组
     * @return 返回最大水位值
     */
    public int maxArea(int[] height) {
        //定义左右指针
        int left = 0;
        int right = height.length - 1;
        //定义初始的最大值
        int max = -1;

        while (left < right) {
            //获取最低水平的值
            int min = Math.min(height[left], height[right]);
            //获取当前的水量值
            int ret = (right - left) * min;
            //和最大水量值进行比较，若大于，则更新最大水量值
            if (ret > max) max = ret;

            //左右指针对应的水位值：谁低谁移动
            if (height[left] < height[right]) left++;
            else right--;
        }
        //最大水位值
        return max;
    }
}