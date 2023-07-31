package demo;

/**
 * 二进制的操作
 */
public class Test {
    public static void main(String[] args) {
        int num = 55;
        int num2 = -55;
        //左移一位，即数字 * 2
        leftMove(num,1);
        leftMove(num2,1);

        //右移一位，即数字 / 2 后向下取整
        rightMove(num,1);
        rightMove(num2,1);

    }

    /**
     * 左移
     * @param num       数字
     * @param removeNum 待移动的位数
     */
    public static void leftMove(int num, int removeNum) {
        System.out.println(num << removeNum);
    }

    /**
     * 算术右移和逻辑右移
     * @param num      数字
     * @param rightNum 待右移的指
     */
    public static void rightMove(int num, int rightNum) {
        System.out.println(num >> rightNum);//算术右移
        System.out.println(num >>> rightNum);//逻辑右移
    }
}
