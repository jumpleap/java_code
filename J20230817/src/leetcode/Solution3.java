package leetcode;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 */
class Solution3 {
    /**
     * 思路分析：快慢指针，最后判断快慢指针的值是否为1
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param n 给定的n
     * @return 判断最后的值是否为1
     */
    public boolean isHappy(int n) {
        //定义快慢指针
        int slow = n;
        int fast = bitSum(n);

        //当快慢指针相同时，退出循环
        while (slow != fast) {
            slow = bitSum(slow);
            fast = bitSum(bitSum(fast));
        }
        //最后判断快慢指针的值是否为1
        return slow == 1;
    }

    //获取每位数的自身乘积之和
    private int bitSum(int n) {
        int sum = 0;
        while (n != 0) {
            //获取末位数
            int tmp = n % 10;
            //累加末位数的乘积
            sum += tmp * tmp;
            //迭代
            n /= 10;
        }
        return sum;
    }
}