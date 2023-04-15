package basicknow;

import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    public static void main(String[] args) {
        //实现猜数字游戏
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randNum = random.nextInt(101);//随机生成1-100的数字
        int guessNum = 0;

        while (true) {
            System.out.println("请输入你要猜测的数字：");
            guessNum = scanner.nextInt();

            if (guessNum == randNum) {
                System.out.println("恭喜你，猜对了~");
                break;
            } else if (guessNum < randNum) {
                System.out.println("猜小了~");
            } else {
                System.out.println("猜大了~");
            }
        }
    }
}
