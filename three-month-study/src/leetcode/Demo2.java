package leetcode;

import java.util.Arrays;

/**
 * @author 林沐雨
 * @date 2024/12/1
 */
public class Demo2 {
    /**
     * 链接：<a href="https://leetcode.cn/problems/container-with-most-water/"> 盛最多水的容器 </a>
     * 思路分析：利用数组单调性，使用双指针 -- 左右指针，左指针指向数组首元素，右指针指向数组最后一个元素，判断那边的水位【高度】低
     *          使用低的水位和当前左右指针的距离进行相乘，得到一个容量值，用这个容量值和 max 进行计算
     *          大于 max 则把这个值存储到 max 中，然后水位低下标的进行移动，进行下一步计算
     * 时间复杂度：O(N)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        // 定义双指针
        int left = 0;
        int right = height.length - 1;
        // 获取最大值
        int max = 0;
        // 获取水的水量
        int v = 0;

        // 相遇后跳出循环
        while (left < right) {
            // 判断那边的水位低，低的用于计算，低的下标进行移动
            if (height[right] > height[left]) {
                v = height[left] * (right - left);
                left++;
            } else {
                v = height[right] * (right - left);
                right--;
            }

            // 获取最大值
            max = Math.max(max, v);
        }
        // 返回最大值
        return max;
    }


    /**
     * 链接：<a href="https://leetcode.cn/problems/valid-triangle-number/"> 有效三角形的个数 </a>
     * 思路分析：排序，固定一个最大值，利用双指针 -- 左右指针，左指针指向数组首下标，右指针指向最大值的前一个下标
     *          然后利用单调性来进行判断左右指针的区间内的有效三角形的个数，当左右指针的值相加后
     *          和大于固定的最大值，则说明当前左右指针这个区间任意两个数相加都大于最大值，则计数这个区间内的三角形个数，右指针左移
     *          用于继续判断下一个左右区间内的三角形个数
     *          和小于固定的最大值，则需要左指针右移，继续判断右移后区间的三角形个数
     * 时间复杂度：O(NlogN) + O(N^2)
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        // 进行优化
        Arrays.sort(nums);
        // 统计有效三角形的个数
        int count = 0;

        // 固定最大的数
        for (int i = n - 1; i >= 2; i--) {
            // 定义双指针
            int left = 0;
            int right = i - 1;

            // 把 left 到 right 区间内的所有有效三角形进行计数
            // 相遇后跳出循环
            while (left < right) {
                // 若是大于，则说明 left -> right 区间内的值和都大于最大值
                // right 左移，继续判断 right 左移后的区间
                if (nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right--;
                } else {
                    // 若是小于，则需要 left 右移，然后判断 left 右移后的区间
                    left++;
                }
            }

            // 到这个地方后，已经把当前的 [left, right]内的有效三角形进行计算完毕
            // 下一步循环我们固定下一个最大值
        }
        return count;
    }


    /**
     * 链接：<a href="https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/"> 和为target的两个数 </a>
     * 思路分析：数组是有序的，即具有单调性；定义双指针 -- 左右指针，左指针指向数组首元素，右指针指向数组最后一个元素
     *          获取左右指针相加之和，和大于目标值，则右指针左移；和小于目标值，则左指针右移；相等则返回左右指针对应的值
     * 时间复杂度：O(N)
     * @param price
     * @param target
     * @return
     */
    public int[] twoSum(int[] price, int target) {
        // 定义双指针
        int left = 0;
        int right = price.length - 1;

        // 相遇后跳出循环
        while (left < right) {
            // 数组是升序的，当左右指针和大于目标值，则 right左移
            if (price[left] + price[right] > target) {
                right--;
            } else if (price[left] + price[right] < target) {
                // left 右移
                left++;
            } else {
                // 找到了目标值，返回对应的价格即可
                return new int[]{price[left], price[right]};
            }
        }
        // 没找到
        return new int[]{0, 0};
    }
}
