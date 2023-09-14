package datastrcture;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = new int[]{2, 12, 1, 34, 23, 45, 65, 6, 7, 123, 90, 7};
        //Sort.mergeSortFunc(array);
        Sort.mergeSortNor(array);
        System.out.println(Arrays.toString(array));
    }
}
