package data_structure.queue;

import java.util.Stack;
// 栈实现队列
// 思路: 栈的特点是后进先出, 队列的特点是先进先出;
// 两个辅助栈s1, s2, s1用来入元素, 把要入队列的元素全部放到该栈中;
// s2用来出元素,当s2为空时, 把s1中的元素全部放到s2中, 再进行出元素
public class LeetCode {
    class MyQueue {
        // 创建两个栈
        private Stack<Integer> s1;
        private Stack<Integer> s2;

        // 初始化
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        // 入队
        public void push(int x) {
            s1.push(x);
        }

        // 出队
        public int pop() {
            // 判空
            if (empty()) {
                return -1;
            }

            // 把s1中的元素逆置到s2中
            reverse();
            // 进行弹出
            return s2.pop();

        }

        // 获取队头元素
        public int peek() {
            // 判空
            if (empty()) {
                return -1;
            }
            // 把s1中的元素逆置到s2中
            reverse();
            // 返回s2的队头元素
            return s2.peek();
        }

        // 判空
        public boolean empty() {
            return s1.empty() && s2.empty();
        }

        // 逆置操作
        private void reverse() {
            // s2为空, 则需要把s1中的元素逆置到s2中
            while (s2.empty()) {
                // s1不为空, 进行弹出元素到s2
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
            }
        }
    }
}
