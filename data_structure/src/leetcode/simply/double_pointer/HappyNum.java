package leetcode.simply.double_pointer;

// 快乐数
public class HappyNum {
    /*
        编写一个算法来判断一个数 n 是不是快乐数。
        「快乐数」 定义为：
        对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
        然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
        如果这个过程 结果为 1，那么这个数就是快乐数。
        如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
        链接：https://leetcode.cn/problems/happy-number/description/
     */

    /**
     * 法一： 模拟
     * 思路：10以内1和7都能得到1，我们判断7以上的数是否多轮循环后能到1，比7小说明到不了
     * 时间复杂度：O(N)
     * @param n
     * @return
     */
    public boolean isHappy1(int n) {
        // 10以内1和7是个特例
        if (n == 1 || n == 7) return true;

        // 判断7以上的数
        while (n > 6) {

            int num = n;
            int sum = 0;

            // 获取n每个位的平方和
            while (num != 0) {
                int tmp = num % 10;
                sum += tmp * tmp;
                num /= 10;
            }

            // 判断结果
            if (sum == 1) return true;
            // 不是1，重置n
            n = sum;
        }
        return false;
    }

    /**
     * 法二；双指针 -- 快慢指针
     * 思路：定义快慢指针，快指针每次在原有快指针的基础上走两步，慢指针在慢指针原有的基础上走一步
     *      相遇后退出循环，判断相遇的值是否为1
     * 时间复杂度：O(N)
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        // 定义快慢指针
        int slow = get(n);
        int fast = get(get(n));

        // 相等跳出
        while (slow != fast) {
            // slow在原先的基础上每次走一步
            slow = get(slow);
            // fast在原先的基础上走两步
            fast = get(get(fast));
        }
        // 相遇后判断结果是否为1
        return slow == 1;
    }

    private int get(int n) {
        int sum = 0;

        // 计算每个位的平方和
        while (n != 0) {
            int tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }
}
