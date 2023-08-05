package leetcodeplus;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
请定义一个队列并实现函数 max_value 得到队列里的最大值，
要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
若队列为空，pop_front 和 max_value 需要返回 -1
 */
class MaxQueue {

    Queue<Integer> queue;//普通队列
    Deque<Integer> maxQueue;//双端队列

    public MaxQueue() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    //获取双端队列的最大值
    public int max_value() {
        //判空
        if (maxQueue.isEmpty()) {
            return -1;
        }
        return maxQueue.peek();
    }

    //入队：双端队列入队的时候往后面入队，按照递减的形式排列
    public void push_back(int value) {
        queue.offer(value);
        //判空
        if (maxQueue.isEmpty()) {
            maxQueue.offer(value);
            return;
        }

        //让双端队列进行递归排序，使用双端队列的末尾的数字和value进行比较
        //若大于，则让双端队列的尾部弹出，不大于，则把value添加到尾部
        while (!maxQueue.isEmpty() && value > maxQueue.peekLast()) {
            maxQueue.pollLast();
        }
        maxQueue.offerLast(value);
    }

    //出队：需要判断最大值队列的出队元素
    public int pop_front() {
        //判空
        if (queue.isEmpty()) {
            return -1;
        }
        //获取两个队列的队头元素
        int m = queue.peek();
        int n = maxQueue.peekFirst();
        //比较，相等则弹出
        if (m == n) {
            maxQueue.pollFirst();
        }
        return queue.poll();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */