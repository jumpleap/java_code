package leetcode;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
class Solution1 {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums 给定的数组
     */
    public void moveZeroes(int[] nums) {
        //目标指针：用于保证在此下标内的值都是非0元素
        int dest = -1;
        //cur遍历指针：用于判断当前值是否非0
        for (int cur = 0; cur < nums.length; cur++) {
            //当cur不为0时，则需要和目标指针进行交换值
            if (nums[cur] != 0) {
                //dest指到最后一个非0元素的位置上,需自增
                dest++;
                //交换0值和非0值，使非0值均在dest的下标范围内
                int tmp = nums[cur];
                nums[cur] = nums[dest];
                nums[dest] = tmp;
            }
        }
    }
}