package leetcode;

import java.util.Scanner;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 */
public class IsHappy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            System.out.println(isHappy(num));
        }
    }

    /**
     * 判断是不是快乐数
     * @param n 要转化的值
     * @return 返回布尔类型的值
     */
    public static boolean isHappy(int n) {
        //特殊情况1和7是可以得到最后的结果是1的
        if (n == 1) {
            return true;
        }
        while (n > 6) {
            int sum = 0;//每次的sum值都不一样
            int tmp = n;//临时值，用于求当前n的sum
            while (tmp != 0) {
                //求每个数的平方
                int x = tmp % 10;
                sum += Math.pow(x, 2);
                tmp /= 10;
            }
            //判断得到的数是不是为1
            if (sum == 1)
                return true;
            //替换n
            n = sum;
        }
        return false;
    }
}
