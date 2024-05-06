package binary_search;

// 二分查找
public class Demo1 {
    /*
        给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
        写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
        链接: https://leetcode.cn/problems/binary-search/description/
     */

    /**
     * 思路分析: 二分查找
     *      使用left和right固定要查找的区间, 获取中值, 根据中值分为左右两个区间, 判断target在那个区间内
     *      target在左区间, right在中值下标-1处; target在右区间, left在中值下标+1处; 直到left>right跳出循环
     * 时间复杂度: O(logN)
     * 空间复杂度: O(1)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // 定义区间
        int left = 0;
        int right = nums.length - 1;

        // left <= right: 防止只有一个数的情况
        while (left <= right) {
            // 获取中值(防止溢出)
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) { // 处于左区间
                // right指向mid左边1位
                right = mid - 1;
            } else if (nums[mid] < target) { // 处于右区间
                // left指向mid右边一位
                left = mid + 1;
            } else { // 返回相等下标
                return mid;
            }
        }
        // 没有找到
        return -1;
    }
}

