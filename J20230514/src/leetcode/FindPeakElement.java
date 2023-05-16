package leetcode;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，
 * 在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 */
public class FindPeakElement {
    public static void main(String[] args) {

    }

    /**
     * 顺序查找（比较左右两边的元素）
     * 时间复杂度：O(n)；空间复杂度O(1)
     * @param nums 峰值数组
     * @return 返回值
     */
    public int findPeakElement1(int[] nums) {
        int peakNum = 0;//峰值默认为0
        for (int i = 1; i < nums.length - 1; i++) {
            //判断峰值
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peakNum = i;
                break;
            }
        }
        //如果peakNum为0，则说明峰值在第一个或最后一个
        if (peakNum == 0) {
            return nums[0] > nums[nums.length - 1] ? 0 : nums.length - 1;
        }
        return peakNum;
    }

    /**
     * 二分查找
     * 时间复杂度：O(lonN)；空间复杂度O(1)
     * @param nums 峰值数组
     * @return 返回值
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) >> 1;

            //说明左边右峰值
            if (nums[mid] > nums[mid + 1]) {
                //有边界固定
                right = mid;
            } else {
                //说明右边有峰值
                left = mid + 1;
            }
        }
        //返回右值
        return right;
    }
}