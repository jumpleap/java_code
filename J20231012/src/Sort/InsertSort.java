package Sort;

import java.util.Arrays;

public class InsertSort {
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{9, 87, 6, 5, 4, 3, 2, 1, 12, 3};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
