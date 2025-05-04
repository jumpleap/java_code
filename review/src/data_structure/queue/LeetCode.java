package data_structure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author 林沐雨
 * @Date 2025/4/30
 * @Description
 */
public class LeetCode {
    // https://leetcode.cn/problems/implement-stack-using-queues/description/
    class MyQueue {
        private Stack<Integer> s1;
        private Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack();
            s2 = new Stack();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            if (empty())
                return -1;
            if (s2.empty()) {
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        public int peek() {
            if (empty())
                return -1;
            if (s2.empty()) {
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        public boolean empty() {
            return s1.empty() && s2.empty();
        }
    }

    // https://leetcode.cn/problems/implement-queue-using-stacks/description/
    class MyStack {
        private Queue<Integer> q1;
        private Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList();
            q2 = new LinkedList();
        }

        public void push(int x) {
            q1.offer(x);

            // q2不为空，把q2的元素放到q1的后面，形成逆置
            while (!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
            Queue<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
        }

        public int pop() {
            if (empty()) return -1;
            return q2.poll();
        }

        public int top() {
            if (empty()) return -1;
            return q2.peek();
        }

        public boolean empty() {
            return q2.isEmpty();
        }
    }
}
