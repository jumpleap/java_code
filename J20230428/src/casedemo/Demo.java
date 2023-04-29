package casedemo;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};

        int[] copy = Arrays.copyOf(array,10);
        System.out.println(Arrays.toString(copy));
    }
}
