package data_structure.queue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    // 创建两个队列
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    // 初始化
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }


    // 入栈
    public void push(int x) {
        // q1入队
        q1.offer(x);

        // q2不为空, 则把q2中的值入到q1中
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        // 代码执行到此, q2为空, q1则是把队列中的数字逆置了
        // 交换,让q1指向空, 让q2指向q1
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;

    }

    // 出栈
    public int pop() {
        // 判空
        if (empty()) {
            return -1;
        }
        return q2.poll();
    }

    // 获取栈顶元素
    public int top() {
        if (empty()) {
            return -1;
        }
        return q2.peek();
    }

    // 判断栈空
    public boolean empty() {
        return q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */