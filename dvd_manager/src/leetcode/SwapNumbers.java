package leetcode;

/**
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 */
public class SwapNumbers {
    /**
     * 异或交换
     * @param numbers 交换数组中的元素
     * @return 返回交换后的数组
     */
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }

    /**
     * 直接返回新数组
     * @param numbers 交换数组中的元素
     * @return 返回交换后的数组
     */
    public int[] swapNumbers1(int[] numbers) {
        return new int[]{numbers[1], numbers[0]};
    }
}
