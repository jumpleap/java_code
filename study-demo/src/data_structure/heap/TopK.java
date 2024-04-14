package data_structure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

// Top-K问题解决
/*
    设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
    链接: https://leetcode.cn/problems/smallest-k-lcci/description/
 */
public class TopK {
    /**
     * 排序
     * 时间复杂度: O(NlogN)
     * 空间复杂度: O(K)
     */
    public int[] smallestK1(int[] arr, int k) {
        // 初始化数组
        int[] ans = new int[k];
        // 说明没有最小的k个数
        if (k == 0) return ans;

        // 对数组进行排序
        Arrays.sort(arr);

        // 取前k个最小的数
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        // 返回最小的k个数
        return ans;
    }

    /**
     * 堆 -> 大根堆
     * 时间复杂度: O(NlogK), 插入删除都是logK
     * 空间复杂度: O(N)
     */
    public int[] smallestK(int[] arr, int k) {
        // 初始化数组
        int[] ans = new int[k];
        // 说明没有最小的k个数
        if (k == 0) return ans;

        // 创建大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        // 把前k个元素先入堆
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        // 继续遍历后面的元素
        for (int i = k; i < arr.length; i++) {
            // 判断当前的元素是否小于堆顶元素, 小于则把堆顶元素出堆再进当前元素
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        // 此时, 堆中剩余的元素就是前k个最小的元素
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        // 返回结果
        return ans;
    }

}