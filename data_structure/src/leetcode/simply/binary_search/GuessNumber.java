package leetcode.simply.binary_search;

import java.util.Random;

// 猜数字
public class GuessNumber {
    /*
        我们正在玩猜数字游戏。猜数字游戏的规则如下：
        我会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
        如果你猜错了，我会告诉你，我选出的数字比你猜测的数字大了还是小了。
        你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有三种可能的情况：
        -1：你猜的数字比我选出的数字大 （即 num > pick）。
        1：你猜的数字比我选出的数字小 （即 num < pick）。
        0：你猜的数字与我选出的数字相等。（即 num == pick）。
        返回我选出的数字。
        https://leetcode.cn/problems/guess-number-higher-or-lower/description/
     */

    // 二分查找
    public int guessNumber(int n) {
        // 定义左右指针
        int left = 0;
        int right = n;
        // 中间值
        int mid = 0;

        // 当left > right跳出循环
        while (left <= right) {
            // 获取中值
            mid = left + (right - left) / 2;
            // 中值比猜的值大
            if (guess(mid) == -1) {
                right = mid - 1;
            } else if(guess(mid) == 1){
                // 中值比猜的值小
                left = mid + 1;
            } else {
                // 猜对了
                return mid;
            }
        }
        // 返回结果
        return mid;
    }

    private int guess(int num) {
        Random random = new Random();
        int data = random.nextInt(10);
        return data;
    }
}
