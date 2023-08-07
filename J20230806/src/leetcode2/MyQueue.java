package leetcode2;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 */
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    //入队
    public void push(int x) {
        //s1只需要管入栈
        s1.push(x);
    }

    //出队
    public int pop() {
        //判空
        if (empty()) {
            return -1;
        }
        //若是s2为空
        if (s2.isEmpty()) {
            //则把s1中的元素给s2，且元素已经是和队列的先进先出元素一致
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        //弹出栈顶元素
        return s2.pop();
    }

    //获取队头元素
    public int peek() {
        //判空
        if (empty()) {
            return -1;
        }
        //s2为空，则把s1中的所有元素按照先进先出的状态给s1
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        //获取栈顶元素
        return s2.peek();
    }

    //判空
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */