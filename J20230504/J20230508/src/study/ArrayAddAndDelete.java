package study;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayAddAndDelete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //定义数组
        int[] array = new int[]{1, 2, 3, 4, 5};
        //拷贝数组
        array = Arrays.copyOf(array, array.length + 1);
        System.out.println("请输入你要增加的元素:");
        int num = scanner.nextInt();
        //增加元素
        array[array.length - 1] = num;
        System.out.println(Arrays.toString(array));

        System.out.println("请你输入你要删除的元素：");
        int index = 0;
        num = scanner.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (num != array[i]) {
                array[index++] = array[i];
            }
        }

        for (int i = 0; i < index; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
