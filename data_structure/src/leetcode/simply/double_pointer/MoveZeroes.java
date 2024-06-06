package leetcode.simply.double_pointer;

// 移动0
public class MoveZeroes {
    /*
        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
        请注意 ，必须在不复制数组的情况下原地对数组进行操作。
        链接：https://leetcode.cn/problems/move-zeroes/description/
     */


    /**
     * 法一: 临时数组
     * 空间复杂度：O(K) K: 为数组nums的长度
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        // 申请临时数组
        int[] tmpArr = new int[nums.length];

        // 把1值存储在临时数组中
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                tmpArr[index++] = nums[i];
            }
        }

        // 把临时数组中的值赋给nums
        for(int i = 0; i < tmpArr.length; i++) {
            nums[i] = tmpArr[i];
        }
    }


    /**
     * 法二：双指针
     * 思路：left指向非0元素的最后一个位置，right进行遍历数组，遇到0值跳过，遇到非0值则和left进行交换元素位置
     * 时间复杂度：O(N)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // 初始化双指针
        int left = -1;
        int right = 0;

        while (right < nums.length) {
            // 若right对应的值不为0，则把这个值和前面的0值进行交换
            if (nums[right] != 0) {
                // 先自增，到0元素的第一个位置【即非0元素最后一个位置】
                ++left;
                // 交换
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                // 交换后right指向下一个
                right++;
            } else {
                // 遍历
                right++;
            }
        }
    }
}
