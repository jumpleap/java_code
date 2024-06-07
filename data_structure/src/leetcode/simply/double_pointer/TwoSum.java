package leetcode.simply.double_pointer;

// 查找总价格为目标值的两个商品
public class TwoSum {
    /*
        购物车内的商品价格按照升序记录于数组 price。请在购物车中找到两个商品的价格总和刚好是 target。
        若存在多种情况，返回任一结果即可。
        链接：https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/description/
     */

    /**
     * 法一：暴力枚举
     * 时间复杂度： O(N^2)
     * @param price
     * @param target
     * @return
     */
    public int[] twoSum1(int[] price, int target) {
        for (int i = 0; i < price.length; i++) {
            for (int j = i + 1; j < price.length; j++) {
                // 若相等， 则返回这两个值
                if (price[i] + price[j] == target) {
                    return new int[]{price[i], price[j]};
                }
            }
        }
        // 没有找到
        return new int[]{-1, -1};
    }

    /**
     * 法二：利用单调性【数组按升序】，使用双指针
     * 思路分析：
     *      1.定义左右双指针，left = 0， right = n - 1;
     *      2. 分情况讨论
     *          a.left和right对应值相加大于target，right--;
     *          b.left和right对应值相加小于target，left++;
     *          c.相等
     *      3.返回结果
     * 时间复杂度：O(N)
     * @param price
     * @param target
     * @return
     */
    public int[] twoSum(int[] price, int target) {
        // 定义双指针
        int left = 0;
        int right = price.length - 1;

        // 相遇跳出
        while (left < right) {
            // 大于则right左移，因为left后面的数和right相加都大于target
            if (price[left] + price[right] > target) {
                right--;
            } else if (price[left] + price[right] < target) {
                // 小于，则left右移，因为right前面的数和left相加都小于target
                left++;
            } else {
                // 相等，返回
                return new int[]{price[left], price[right]};
            }
        }
        // 不存在
        return new int[]{-1, -1};
    }
}
