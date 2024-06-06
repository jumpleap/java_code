package ds.sort;

import java.util.Arrays;
import java.util.Random;

import static sun.plugin2.gluegen.runtime.BufferFactory.getArray;

public class Demo {
    public static void main(String[] args) {
        int[] arr = getArray();
        System.out.println(Arrays.toString(arr));
        QuickSort sort = new QuickSort();
        //sort.quickSort(arr);
        sort.quickSortNor(arr);
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
