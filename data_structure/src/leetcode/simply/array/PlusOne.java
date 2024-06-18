package leetcode.simply.array;

// 加一
public class PlusOne {
    /*
        给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
        最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
        你可以假设除了整数 0 之外，这个整数不会以零开头。
        https://leetcode.cn/problems/plus-one/description/
     */

    /**
     * 模拟
     * 思路：
     *      情况1：数组中没有9的存在，数组最后一个下标对应值自增1后，返回该数组
     *      情况2：数组中有9的存在，但不是全9，从后往前进行判断，若当前数是9，则置为0，
     *              若当前数不是9，则当前自增1，返回数组
     *      情况3：数组中的值为全9，那么申请一个比当前数组长度多1的数组，然后把0下标置为1，返回
     *              全9加1后，结果首下标必为1，后面都是0
     * 时间复杂度：O(N)
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        // 从最后的下标开始进行判断
        for(int i = digits.length - 1; i >= 0; i--) {
            // 如果当前的数为9，则置为0
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                // 不为9，则当前数自增1
                digits[i] += 1;
                // 返回数组
                return digits;
            }
        }
        // 若是没有在循环中返回的情况，那么数组中的数都是9
        // 申请多一个空间
        digits = new int[digits.length + 1];
        // 0下标置为1，因为都为9，最好结果为10.....
        digits[0] = 1;
        // 返回结果
        return digits;
    }
}
