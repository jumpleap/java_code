package leetcode.simply.binary_search;

// 搜索插入位置
public class SearchInsert {
    /*
        给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
        如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
        请必须使用时间复杂度为 O(log n) 的算法。
        https://leetcode.cn/problems/search-insert-position/description/
     */

    /**
     * 二分查找
     * 思路：
     *      1.定义数组首尾下标：left = 0, right = nums.length - 1;
     *      2.进入循环，当left > right跳出循环
     *          a.获取中值
     *          b.使用中值和目标值判断，中值大于目标值则right左移；小于则left右移；等于则返回当前下标
     *      3.跳出循环，没有在循环中返回下标，说明没有和该目标值相同的数，则返回left，当前left的位置是target应该存在的位置
     * 时间复杂度：O(logN)
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        // 获取数组首尾下标
        int left = 0, right = nums.length - 1;

        // left > right跳出循环
        while (left <= right) {
            // 获取中值
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                // 中值比目标值大，right左移到mid-1的位置
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 中值比目标值小，left右移到mid+1的位置
                left = mid + 1;
            } else {
                // 值相等，返回下标
                return mid;
            }
        }

        // 到这个地方，有两种情况
        // 1.没有找到相等值，此时left比right大
        // 2.没有找到相等值，left比right小
        return left;
    }
}
