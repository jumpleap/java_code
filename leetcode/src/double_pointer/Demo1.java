package double_pointer;

// 双指针
public class Demo1 {
    /*
        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
        请注意 ，必须在不复制数组的情况下原地对数组进行操作。
        链接: https://leetcode.cn/problems/move-zeroes/description/
     */

    /**
     * 思路分析: 双指针
     *      left指向0值, right指向非0值, right遇到0值则跳过, 遇到非0值则和left进行交换,
     *      交换后left++, 0值后移, 非0值前移; 直到所有的0值都在数组最后面
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // 指向0值
        int left = 0;
        // 指向非0值
        int right = 0;

        while (right < nums.length) {
            // 遇到非0值, 把前面的0值换到后面, 即0值后移
            if (nums[right] != 0) {
                int tmp = nums[right];
                nums[right] = nums[left];
                // left和right交换后, left指向下一个0值
                nums[left++] = tmp;
            }
            right++;
        }
    }
}
