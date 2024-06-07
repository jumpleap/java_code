package ds.sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSortTest {
    public static void main(String[] args) {
        int[] arr = getArray();
        System.out.println(Arrays.toString(arr));
        MergeSort sort = new MergeSort();
        sort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static int[] getArray() {
        Random random = new Random();
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1;
        }
        return arr;
    }
}
