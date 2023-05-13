package leetcode;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 5}));
    }

    public static int singleNumber(int[] nums) {
        //异或的性质解决：相同的数异或为0，0和任何数异或为任何数
        int ret = nums[0];

        for (int i = 1; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }
}
