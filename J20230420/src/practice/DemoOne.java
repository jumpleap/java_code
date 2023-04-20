package practice;

import java.util.Arrays;
@SuppressWarnings({"all"})

public class DemoOne {
    public static void main(String[] args) {
        //二维数组的使用
        int[][] array = {{1, 2, 3}, {4, 5, 6}};//2行3列的二维数组

        //二维数组的形式
        int[][] array1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] array2 = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int[][] array3 = new int[2][3];

        //array.length -> 行数  array[i].length -> 每行的个数
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();//换行
        }

        //打印地址
        Arrays.toString(array[0]);
        Arrays.toString(array[1]);

        //使用Arrays.deepToString()方法打印二维数组
        Arrays.deepToString(array);

        //不规则的二维数组
        int[][] arr = new int[2][];
        //列数可以不确定
        arr[0] = new int[]{1,2,3};
        arr[1] = new int[]{1,2,3,4,5};
        Arrays.deepToString(arr);
    }
}
