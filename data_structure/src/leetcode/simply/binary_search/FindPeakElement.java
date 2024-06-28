package leetcode.simply.binary_search;

// 寻找峰值
public class FindPeakElement {
    /*
        峰值元素是指其值严格大于左右相邻值的元素。
        给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
        你可以假设 nums[-1] = nums[n] = -∞ 。
        你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
        https://leetcode.cn/problems/find-peak-element/description/
     */

    /**
     * 遍历思路, 从1开始判断左右的元素是否都小于当前元素，小于则为峰值；若是没有找到，则判断首尾位置谁大，谁就是峰值
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int findPeakElement1(int[] nums) {
        // 假设定义0下标的值为峰值
        int peakNum = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            // 判断峰值：峰值比左右两侧值大即为峰值
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                return i;
            }
        }

        // 出循环的情况：
        // 1.数组元素只有两个及其以下，无法获取峰值
        // 2.数组峰值在0元素或者最后一个元素下标，无法获取峰值

        // 判断数组元素只有两个数及其以下的情况
        // if (nums.length == 2) {
        //     return nums[0] > nums[1] ? 0 : 1;
        // }
        // // 判断峰值在0下标还是末尾下标
        // return nums[0] > nums[nums.length - 1] ? 0 : nums.length - 1;

        // 上述两种情况合并
        return nums[0] > nums[nums.length - 1] ? 0 : nums.length - 1;
    }


    /**
     * 法二：二分
     *      获取中值，判断中值和中值右边的一个元素，判断谁大，中值大，则说明峰值在左边， 否则峰值在右边
     *      最后返回right对应的中值即可
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        // 定义left 和 right进行二分
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // 获取中值
            int mid = left + (right - left) / 2;

            // 判断中值比中值右边一位的值是否大，大的话则说明中值在左边；
            // 否则中值在右边
            // 峰值在左边
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                // 峰值在右边
                left = mid + 1;
            }
        }
        // 跳出循环后，峰值就是right对应的值
        return right;
    }
}
