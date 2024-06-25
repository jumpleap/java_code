package leetcode.simply.bit_operation;

// 找不同
public class FindTheDifference {
    /*
        给定两个字符串 s 和 t ，它们只包含小写字母。
        字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
        请找出在 t 中被添加的字母。
        https://leetcode.cn/problems/find-the-difference/description/
     */

    /**
     * 法一：哈希映射
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference1(String s, String t) {
        // 定义哈希数组
        int[] hash = new int[128];

        // 进行字符映射
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - '0']++;
        }

        // 在t字符串中进行hash中的值进行比较
        for (int i = 0; i < t.length(); i++) {
            // 若hash中对应的值为0，说明不存在
            if (hash[t.charAt(i) - '0'] == 0) {
                // 直接返回这个字符即可
                return t.charAt(i);
            } else {
                // 存在，判断这个字符是否存在多次，在这次需要自减一次
                if (hash[t.charAt(i) - '0'] != 0) {
                    hash[t.charAt(i) - '0']--;
                }
            }
        }
        // 没有多的字符则返回空字符
        return ' ';
    }

    // 法二：异或
    // 相同数异或结果为0，任何数和0异或结果为自身

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char ans = 0;

        // 先异或s字符串
        for (int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
        }

        // 在异或t字符串
        for (int i = 0; i < t.length(); i++) {
            ans ^= t.charAt(i);
        }
        // 到这个地方，就能得到s字符串中多出来的那个字符串
        // 返回该字符
        return ans;
    }
}
