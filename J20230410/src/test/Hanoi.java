package test;

import java.util.Scanner;
@SuppressWarnings({"all"})

public class Hanoi {
    public static void main(String[] args) {
        //实现汉诺塔
        Scanner scanner = new Scanner(System.in);
        int plate = 0;
        System.out.println("请输入汉诺塔上的盘子数：");
        plate = scanner.nextInt();
        char num1 = 'A';
        char num2 = 'B';
        char num3 = 'C';

        hanoi(plate, num1, num2, num3);
    }

    private static void move(char pos1, char pos2) {
        System.out.print(pos1 + "->" + pos2 + " ");
    }

    /**
     * 汉诺塔的代码实现
     * @param plate
     * @param pos1
     * @param pos2
     * @param pos3
     */
    private static void hanoi(int plate, char pos1, char pos2, char pos3) {
        if (plate == 1) {
            move(pos1, pos3);
        } else {
            //从A到B，C作为中转站
            hanoi(plate - 1, pos1, pos3, pos2);
            //pos1最后一个盘子到移动到pos3
            move(pos1, pos3);
            //从B到C，A作为中转站
            hanoi(plate - 1, pos2, pos1, pos3);
        }
    }
}
