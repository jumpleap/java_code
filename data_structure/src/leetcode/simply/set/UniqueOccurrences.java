package leetcode.simply.set;

import java.util.HashSet;
import java.util.Set;

// 独一无二的出现次数
public class UniqueOccurrences {
    /*
        给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
        如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
        https://leetcode.cn/problems/unique-number-of-occurrences/description/
     */

    /**
     * 法一：哈希映射+哈希表去重判断
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences1(int[] arr) {
        // 统计数组
        int[] count = new int[2001];

        // 进行映射，统计每个数字出现的次数
        for (int num : arr) {
            // 因为数值在-1000到1000之间
            count[num + 1000]++;
        }

        // 定义哈希表
        Set<Integer> ret = new HashSet<>();

        // 查找哈希表中是否存在出现相同次数的数字
        ret.add(count[0]);
        for (int i = 1; i < count.length; i++) {
            // 排除数字没有出现的情况，且判断当前数组是否在哈希表中出现
            if (count[i] != 0 && ret.contains(count[i])) {
                // 出现返回false，说明存在出现相同次数的数字
                return false;
            } else {
                // 未出现则添加到哈希表中
                ret.add(count[i]);
            }
        }
        // 没有相同次数数字的出现
        return true;
    }

    /**
     * 法二：建立两个哈希映射
     *      第一个哈希映射统计数字中数字出现的次数
     *      第二个哈希映射判断是否出现相同次数的次数
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        // 第一个哈希映射数组
        int[] count = new int[2001];

        // 进行映射，统计每个数字出现的次数
        for (int num : arr) {
            // 因为数值在-1000到1000之间
            count[num + 1000]++;
        }

        // 第二个哈希映射数组
        // 为什么是1001, 因为这个数组中的值都是正值，且最大的政治为1000
        int[] ans = new int[1001];
        for (int i = 0; i < count.length; i++) {
            // 当前数字的次数已经出现过了或者没有当前数字
            if (count[i] != 0 && ans[count[i]] == 1) {
                return false;
            }
            ans[count[i]]++;
        }
        return true;
    }
}
