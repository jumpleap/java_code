package practice;

import java.lang.reflect.Array;
import java.util.Arrays;

@SuppressWarnings({"all"})

public class Demo {
    public static void main(String[] args) {

    }

    public static void main6(String[] args) {
        int[] array = {2, 4, 1, 3, 6, 9};
        isFrontOven(array);
        System.out.println(Arrays.toString(array));//[9, 3, 1, 4, 6, 2]
    }

    /**
     * 把奇数放在偶数的前面
     * @param array
     */
    public static void isFrontOven(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            //找到偶数的位置
            while ((left < right) && (array[left] % 2 != 0)) {
                left++;
            }
            //找到奇数的位置
            while ((left < right) && (array[right] % 2 == 0)) {
                right--;
            }
            //奇数偶数交换位置
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }
    }


    public static void main5(String[] args) {
        int[] array = {1, 2, 34, 43, 5, 6, 7};
        int key = 6;
        System.out.println(Arrays.toString(twoSum(array, key)));//[0, 4]
    }

    /**
     * 求和为key的两个值的下标
     *
     * @param array
     * @param key
     * @return
     */
    public static int[] twoSum(int[] array, int key) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                //找到的话直接返回这两个下标
                if (array[i] + array[j] == key) {
                    return new int[]{i, j};
                }
            }
        }
        //没有找到的情况
        return new int[]{-1, -1};
    }

    public static void main4(String[] args) {
        int[] array = {1, 1, 2, 2, 3};
        System.out.println(isOccurOnce(array));//3
    }

    /**
     * 数组中只出现一次的数字
     *
     * @param array
     * @return
     */
    private static int isOccurOnce(int[] array) {
        int ret = array[0];
        //运用了异或的性质
        for (int i = 1; i < array.length; i++) {
            ret ^= array[i];
        }
        return ret;
    }

    public static void main3(String[] args) {
        int[] array = {1, 1, 2, 2, 2, 2, 1};
        System.out.println(isMajorityElement(array));//2
    }

    /**
     * 判断是不是多数数组
     * 另外一种方式：战争法：一人换一人，谁的人多，谁赢
     *
     * @param array
     * @return
     */
    private static int isMajorityElement(int[] array) {
        //使用排序
        Arrays.sort(array);
        return array[array.length / 2];//返回中间值
    }


    public static void main2(String[] args) {
        int[] array = {1, 2, 34, 3, 4, 5, 8, 23, 12};
        //计算连续的奇数
        System.out.println(countOddSum(array));//false
    }

    /**
     * 判断是不是连续的奇数
     *
     * @param array
     */
    private static boolean countOddSum(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            //判断是不是奇数
            if (array[i] % 2 != 0) {
                count++;
                //连续的奇数
                if (count == 3) {
                    return true;
                }
            } else {
                //不是奇数直接重置
                count = 0;
            }
        }
        return false;
    }


    public static void main1(String[] args) {
        int[] array = {1, 2, 34, 3, 4, 5, 8, 23, 12};
        reverse(array);//交换首尾元素
        System.out.println(Arrays.toString(array));
    }

    /**
     * 翻转数组
     *
     * @param array
     */
    private static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            //交换首尾元素
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;

            left++;
            right--;
        }
    }
}
