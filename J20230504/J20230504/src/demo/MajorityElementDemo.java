package demo;

import java.util.Arrays;

/**
 * 多数元素
 */
public class MajorityElementDemo {
    public static void main(String[] args) {
        System.out.println(majorityElement1(new int[]{1, 1, 1, 2, 2, 3, 1}));
        System.out.println(majorityElement(new int[]{1, 1, 1, 2, 2, 3, 1}));
    }

    /**
     * 法一：排序后取中间值
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 法二：战争法:一人换一人的打法，人多的军队获胜
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int len = nums.length;
        int count = 1;//最后剩下的是多的元素
        int cur = nums[0];//得到多的元素

        for (int i = 1; i < len; i++) {
            //判断是否相等
            if (nums[i] == cur) {
                count++;
                //count为0后则需要替换多数元素，并把count重置
            } else if (count == 0) {
                cur = nums[i];
                count = 1;
            } else {
                //不相等
                count--;
            }
        }
        //最后剩下的是多数元素
        return cur;
    }
}