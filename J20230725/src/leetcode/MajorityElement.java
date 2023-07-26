package leetcode;

/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MajorityElement {
    /**
     * 思路分析：抵消法：用target元素和当前数组元素进行比较，若是相同的元素，则自增计数，否则，计数自减
     * 时间复杂度：O(n)
     * @param nums 给定数组
     * @return 返回值
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果count为0了，说明这个数不是多数元素
            if (count == 0) {
                //替换多数元素
                target = nums[i];
                count = 1;
            } else {
                //如果值相同，则count自增
                if (target == nums[i]) {
                    count++;
                } else {
                    //否则，自减
                    count--;
                }
            }
        }
        //最后剩下的是多数元素
        return target;
    }
}