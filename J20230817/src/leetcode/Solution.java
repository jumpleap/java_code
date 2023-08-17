package leetcode;

import java.util.PriorityQueue;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 */
class Solution {
    /**
     * 使用优先级队列建立大根堆，入k个数，判断剩下的数是否大于堆首元素，
     * 若大于则不入，若小于，则弹出堆首元素，再入
     * 时间复杂度：O(n * longN)
     * 空间复杂度：O(k)
     * @param arr 给定数组
     * @param k 给定k
     * @return 返回数组
     */
    public int[] smallestK(int[] arr, int k) {
        int[] ans = new int[k];
        //判断异常情况
        if (arr == null || k == 0) return ans;

        //建立大根堆
        PriorityQueue<Integer> priorityQueue
                = new PriorityQueue<>((o1, o2) -> o2 - o1);

        //入k个数
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }

        //入剩下的数，需要比较
        for (int i = k; i < arr.length; i++) {
            //若比堆首元素小，则需要出后再入
            if (arr[i] < priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }

        //把堆中的元素入到数组中
        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll();
        }
        return ans;
    }
}