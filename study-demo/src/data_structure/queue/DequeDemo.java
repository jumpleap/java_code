package data_structure.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// 双端队列
public class DequeDemo {
    public static void main(String[] args) {
        // 双端队列的链式实现
        Deque<Integer> deque = new LinkedList<>();
        // 双端队列的线性实现
        Deque<Integer> queue = new ArrayDeque<>();
    }
}