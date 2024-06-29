package leetcode.simply.math;

// 完美数
public class CheckPerfectNumber {
    /*
        对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
        给定一个 整数 n， 如果是完美数，返回 true；否则返回 false。
        https://leetcode.cn/problems/perfect-number/description/
     */

    /**
     * 思路：数学， 判断2到sqrt(num)的因子有哪些，然后把因子累加到sum中，最后判断sum和num是否相等。
     * 时间复杂度：O(sqrt(num))
     * 空间复杂度：O(1)
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        // 1除外自身，即为false
        if (num == 1) {
            return false;
        }

        int sum = 1;
        for (int i = 2; i <= num / i; i++) {
            // 说明i是一个因子
            if (num % i == 0) {
                // 把i添加到sum中
                sum += i;

                // i为因子的情况下，判断当前i的平方是否等于num;
                // 不等于则说明有一个配对的因子
                // 为什么这么做? 因为我们已经i的范围在[2，sqrt(num)]中
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }

        // 判断是否相等
        return sum == num;
    }
}
