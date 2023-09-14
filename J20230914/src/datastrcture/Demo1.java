package datastrcture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 计数排序和桶排序
 */
public class Demo1 {
    public static void main(String[] args) {
        //int[] array = new int[]{1, 2, 3, 3, 2, 1, 4, 5, 6, 6, 7, 8, 3, 6, 3, 2, 4, 9, 8, 6};
        int[] array = new int[]{2, 12, 1, 34, 23, 45, 65, 6, 7, 123, 90, 7};
        countSort(array);
        bucketSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 计数排序
     */
    public static void countSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        //定义最大值和最小值
        int minVal = array[0];
        int maxVal = array[0];

        //找到最大值和最小值
        for (int num : array) {
            if (minVal > num) {
                minVal = num;
            }
            if (maxVal < num) {
                maxVal = num;
            }
        }

        //根据最大值和最小值申请数组空间
        int[] tmp = new int[maxVal - minVal + 1];

        //进行计数排序
        for (int i = 0; i < array.length; i++) {
            tmp[array[i] - minVal]++;
        }

        //把计数后的数据重写赋给原数组
        int index = 0;
        for (int i = 0; i < tmp.length; i++) {
            while (tmp[i] > 0) {
                //把值返回
                array[index++] = i + minVal;
                //当前的值个数自减
                tmp[i]--;
            }
        }
    }

    /**
     * 桶排序
     */
    public static void bucketSort(int[] array) {
        //计算最大值和最小值
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }

        //计算桶的数量
        int bucketNumber = (max - min) / array.length + 1;

        //创建桶
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>(bucketNumber);
        for (int i = 0; i < bucketNumber; i++) {
            bucket.add(new ArrayList<Integer>());
        }

        //将每个元素入桶
        for (int i = 0; i < array.length; i++) {
            //判断当前值应该在那个桶中
            int number = (array[i] - min) / array.length;
            //获取对应的桶, 并把值加入到桶中
            bucket.get(number).add(array[i]);
        }

        //对每个桶进行排序
        for (int i = 0; i < bucket.size(); i++) {
            Collections.sort(bucket.get(i));
        }

        //将桶中的元素赋值到原序列
        int index = 0;
        for (int i = 0; i < bucket.size(); i++) {
            //每个桶的长度
            for (int j = 0; j < bucket.get(i).size(); j++) {
                //获取桶中的每个元素
                array[index++] = bucket.get(i).get(j);
            }
        }
    }
}