package priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;//需要导的包

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 */
public class SmallestK {
    /**
     * 思路一：使用小根堆的性质，最后出前k个最小的值
     * 时间复杂度：O(nlog(n)) 空间复杂度：O(n + k)
     * @param arr 源数组
     * @param k   前k个元素
     * @return 返回前k个最小的元素
     */
    public int[] smallestK1(int[] arr, int k) {
        int[] ret = new int[k];//申请空间
        //不符合的情况
        if (k <= 0 || arr == null) {
            return ret;
        }
        //优先级队列 - 小根堆
        PriorityQueue<Integer> q = new PriorityQueue<>();
        //把arr中的所有元素全部入队列
        for (int i = 0; i < arr.length; i++) {
            q.offer(arr[i]);
        }
        //获取前面最小的k个元素
        for (int i = 0; i < k; i++) {
            ret[i] = q.poll();
        }
        return ret;
    }

    /**
     * 思路二：使用大根堆：把小于根的元素入队，然后出根；最后留校的就是最小前k个的元素
     * 时间复杂度：O(nlog(n)) 空间复杂度：O(k)
     * @param arr 源数组
     * @param k   前k个元素
     * @return 返回前k个最小的元素
     */
    public int[] smallestK(int[] arr, int k) {
        int[] ret = new int[k];//申请空间
        //不符合的情况
        if (k <= 0 || arr == null) {
            return ret;
        }
        //优先级队列 - 大根堆
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });

        //入前k个元素
        for (int i = 0; i < k; i++) {
            q.offer(arr[i]);
        }

        //入k个后面的元素
        for (int i = k; i < arr.length; i++) {
            int top = q.peek();
            //判断：若是根大于数组值，则出队，并入数组值
            if (top > arr[i]) {
                q.poll();
                q.offer(arr[i]);
            }
        }

        //获取前k个最小值
        for (int i = 0; i < k; i++) {
            ret[i] = q.poll();
        }
        return ret;
    }
}