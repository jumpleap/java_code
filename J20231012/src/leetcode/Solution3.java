package leetcode;

class Solution3 {
    public int removeDuplicates1(int[] nums) {
        //左右指针
        int left = 0;
        int right = 1;
        //数组长度
        int len = nums.length;

        //遍历数组
        while (right < len) {
            //左右指针的值不相等,则把right的值赋给left++
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
            right++;
        }
        //left是下标, 数组长度需要+1
        return left + 1;
    }

    public int removeDuplicates(int[] nums) {
        return remove(nums, 1);
    }

    private int remove(int[] nums, int k) {
        //记录数组新的下标
        int index = 0;

        for (int num : nums) {
            //保留k为相同的值, 剩下的值也需要保留k位
            if (index < k || nums[index - k] != num) {
                nums[index++] = num;
            }
        }
        //返回数组的新长度
        return index;
    }
}