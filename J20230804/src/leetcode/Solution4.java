package leetcode;

class Solution4 {
    /**
     * 思路分析：二分查找 -> left指向数组首下标，right指向数组尾下标，每次取中间值进行比较
     * 若大于target，则说明往右边找【left = mid + 1】，反之，往左边找【right = mid - 1】;
     * 若找到了，返回对于的下标；注：需要注意只有一个元素和target相等的情况【即条件left <= right】
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * @param nums 给定的有序数组
     * @param target 查找的目标值
     * @return 返回对应的下标或-1
     */
    public int search(int[] nums, int target) {
        //分别指向数组的首尾下标
        int left = 0;
        int right = nums.length - 1;

        //left > right跳出循环
        while (left <= right) {
            //取中值
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) { //往左边找
                right = mid - 1;
            } else if (nums[mid] < target) { //往右边找
                left = mid + 1;
            } else {
                //找到了
                return mid;
            }
        }
        //没找到
        return -1;
    }
}