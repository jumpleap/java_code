package leetcode;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 */
class Solution6 {
    /**
     * 思路分析：左右指针。左指针指向数组首元素，右指针指向数组的最后一个元素。
     * 获取两个指针的水位的最小值【宽】，计算左右指针的距离差【长】，计算当前的水位值。
     * 计算后的水位值和最大水位值进行比较，若大于，则更新最大水位值
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param height 给定的水位数组
     * @return 返回最大水位值
     */
    public int maxArea(int[] height) {
        //定义左右指针
        int left = 0;
        int right = height.length - 1;
        //最大盛水值
        int max = 0;

        while (left < right) {
            //计算盛水值
            int s = Math.min(height[left], height[right]) * (right - left);
            //获取最大盛水值
            if (max < s) max = s;
            //谁的水位低，则谁移动
            if (height[left] < height[right]) left++;
            else right--;
        }
        //返回最大水位值
        return max;
    }
}