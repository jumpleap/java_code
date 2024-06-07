package leetcode.simply.double_pointer;

// 有效三角形的个数
public class TriangleNumber {
    /*
        给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
        链接：https://leetcode.cn/problems/valid-triangle-number/description/
     */

    /**
     * 思路：左右双指针
     *      1.手搓快排给数组排序
     *      2.固定数组中最大的值, i = n - 1;
     *      3.定义左右双指针， left = 0, right = i - 1;
     *      4. 判断left和right相加后的值是否大于固定值
     * 	        a.大于，说明left -> right区间内的值都大于，统计三元组个数，right--, 进行下一轮判断
     * 	        b.小于，让left++，进行下一轮判断
     *      5.返回三元组结果
     *      注：数组排序后，具有单调性
     *
     * 时间复杂度: O(N^2 + NlogN)  NlogN: 快排时间复杂度
     * 空间复杂度：O(logN) 快排消耗
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        // 长度小于3无法构成三元组
        if (nums.length < 3) return 0;

        // 计数器
        int count = 0;
        int n = nums.length;

        // 手搓快排
        quickSort(nums);


        // 固定最大的数
        for (int i = n - 1; i >= 2; i--) {
            // 定义左右指针
            int left = 0;
            int right = i - 1;

            while (left < right) {
                // 获取值
                int val = nums[left] + nums[right];
                // 判断是否大于，若大于，left到right区间内的值都大于
                if (val > nums[i]) {
                    // 计数
                    count += right - left;
                    // right左移
                    right--;
                } else {
                    // 不大于，让left右移
                    left++;
                }
            }
        }
        return count;
    }


    // 手搓快排
    private void quickSort(int[] nums) {
        quick(nums, 0, nums.length - 1);
    }

    private void quick(int[] nums, int left, int right) {
        if (left >= right) return;

        int pivot = partition(nums, left, right);

        quick(nums, left, pivot - 1);
        quick(nums, pivot + 1, right);
    }

    // 挖坑法
    private int partition(int[] nums, int left, int right) {
        int key = nums[left];

        while (left < right) {
            while (left < right && nums[right] >= key) {
                right--;
            }
            nums[left] = nums[right];

            while (left < right && nums[left] <= key) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = key;
        return left;
    }
}
