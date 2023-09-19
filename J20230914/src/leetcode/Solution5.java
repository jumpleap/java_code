package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution5 {
    /**
     * 法一: 优先级队列. 建立大根堆
     * 1) 先入k个值到优先级队列中
     * 2) 继续入数组的值, 和优先级队列的队头元素进行比较, 小于则弹出优先级队列的队头元素且入该元素, 大于不管
     * 3) 创立新数组, 把优先级队列中的值全部入到数组中去,并返回该数组
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * @param arr 给定数组
     * @param k   k值
     * @return 返回最小k个值的数组
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        //特殊情况的判断
        if (k == 0 || arr == null || arr.length == 0) {
            return new int[k];
        }
        //建立优先级队列 -- 大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        //先入k个值
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        //入后面的值, 与前面的值进行比较, 大的则弹出队列
        for (int i = k; i < arr.length; i++) {
            int tmp = queue.peek();
            if (tmp > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        //定义数组
        int[] ans = new int[k];
        int index = 0;

        //把大根堆中的值添加到数组中
        int len = queue.size(); // size是动态变化的
        for (int i = 0; i < len; i++) {
            ans[index++] = queue.poll();
        }
        //返回数组
        return ans;
    }

    /**
     * 法二: 快速排序
     * 时间复杂度: O(NlogN)
     * 空间复杂度:O(logN)
     * @param arr 给定数组
     * @param k   k值
     * @return 返回最小k个值的数组
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        //划分区间
        int pivot = quick(arr, left, right);
        //递归
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private int quick(int[] arr, int left, int right) {
        int key = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            //找到了比key小的值
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            //找到了比key大的值
            arr[right] = arr[left];
        }
        //把原来的基准值赋值到left和right相遇的位置
        arr[left] = key;
        //返回相遇值
        return left;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}