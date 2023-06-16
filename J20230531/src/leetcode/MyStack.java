package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 */
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * 那个队列不为空，就把值入到那个队列中去，默认入到q1队列中去
     */
    public void push(int x) {
        if (!q1.isEmpty()) {
            q1.offer(x);
        } else if (!q2.isEmpty()) {
            q2.offer(x);
        } else {
            q1.offer(x);
        }
    }

    public int pop() {
        if (empty()) {
            return -1;
        }

        if (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size - 1; i++) {
                int tmp = q1.poll();
                q2.offer(tmp);
            }
            return q1.poll();
        } else {
            int size = q2.size();
            for (int i = 0; i < size - 1; i++) {
                int tmp = q2.poll();
                q1.offer(tmp);
            }
            return q2.poll();
        }
    }

    public int top() {
        //判空
        if (empty()) {
            return -1;
        }

        int tmp = -1;
        if (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                tmp = q1.poll();
                q2.offer(tmp);
            }
        } else {
            int size = q2.size();
            for (int i = 0; i < size; i++) {
                tmp = q2.poll();
                q1.offer(tmp);
            }
        }
        return tmp;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}