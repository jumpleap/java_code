package leetcode2;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.offer(x);

        //思路分析：若q2不为空，则把q2中的元素全部添加到q1的后面
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        //到这个地方后，q2为空，q1则是把数字逆置回来了
        //交换指向，让q1指向空，q2指向q1的值
        Queue<Integer> tmp = q2;
        q2 = q1;
        q1 = tmp;
    }

    //弹出栈顶元素
    public int pop() {
        //判空
        if (empty()) {
            return -1;
        }
        return q2.poll();
    }

    //获取栈顶元素
    public int top() {
        if (empty()) {
            return -1;
        }
        return q2.peek();
    }

    //判断栈是否为空
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