package test;

import java.util.Arrays;

public class ChangeToString {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        String ret = myToString(array);
        System.out.println(ret);

        int[] copy = Arrays.copyOf(array,array.length/2);
        System.out.println(Arrays.toString(copy));
    }

    public static String myToString(int[] array) {
        String ret = "[";
        for (int i = 0; i < array.length; i++) {
            ret += array[i];
            //判断最后一个逗号
            if (i != array.length - 1) {
                ret += ",";
            }
        }
        ret += "]";
        return ret;
    }


//    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 4, 5};
//        String str = toString(arr);
//        System.out.println(str);
//    }
//
//    private static String toString(int[] arr) {
//        String str = "";
//        for (int j : arr) {
//            str = j + " " + str;
//        }
//        return str;
//    }
}
