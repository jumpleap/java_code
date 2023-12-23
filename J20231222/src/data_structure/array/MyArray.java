package data_structure.array;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// 数组常用操作
public class MyArray {
    // 初始化操作
    public int[] init(int[] arr) {
        // 无初始化
        // arr = new int[5];
        // int[] nums = {1, 2, 3, 4, 5};
        // 有初始化
        arr = new int[]{1, 2, 3, 4, 5};
        return arr;
    }

    // 随机访问元素
    public int randomAccess(int[] arr) {
        // 在区间[0, arr.length)中随机抽取一个数字
        Random random = new Random();
        int randomIndex = random.nextInt(arr.length);
        // 也可以使用如下方法, 也能获取到0-arr.length的随机值
        // int index = ThreadLocalRandom.current().nextInt(0, arr.length);
        return arr[randomIndex];
    }

    // 在index处插入元素
    public void insert(int[] arr, int index, int data) {
        if (index < 0 || index > arr.length) {
            throw new IndexOfException("下标错误: " + index);
        }

        // 腾出index处的空间给data
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = data;
    }

    // 删除index处的元素
    public void remove(int[] arr, int index) {
        // 下标判断
        if (index < 0 || index >= arr.length) {
            throw new IndexOfException("下标错误: " + index);
        }

        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    // 遍历数组
    public void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 获取数组的长度
    public int size(int[] arr) {
        int count = 0;
        for (int num : arr) {
            count++;
        }
        return count;
    }

    // 查找target元素的下标
    public int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return i;
            }
        }
        // 找不到
        return -1;
    }

    // 数组扩容
    public int[] grow(int[] arr) {
        return Arrays.copyOf(arr, arr.length * 2);
    }
}