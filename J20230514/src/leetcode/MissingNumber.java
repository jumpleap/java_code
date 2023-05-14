package leetcode;

/**
 * 数组nums包含从0到n的所有整数，但其中缺了一个。
 * 请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 */
public class MissingNumber {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n); 空间复杂度：O(1)
     * @param nums 有序数字
     * @return 返回消失的数
     */
    public static int missingNumber1(int[] nums) {
        int ret = 0;
        //累加到0-n的值
        for (int i = 1; i <= nums.length; i++) {
            ret += i;
        }
        //再减去数组中的值，得到的是消失的数字
        for (int i = 0; i < nums.length; i++) {
            ret -= nums[i];
        }
        return ret;
    }

    /**
     * 时间复杂度：O(n); 空间复杂度：O(1)
     * @param nums 有序数字
     * @return 返回消失的数
     */
    public static int missingNumber(int[] nums) {
        int ret = 0;

        //异或0-n的值
        for (int i = 1; i <= nums.length; i++) {
            ret ^= i;
        }

        //再次异或得到缺失的数
        for (int i = 0; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }
}
