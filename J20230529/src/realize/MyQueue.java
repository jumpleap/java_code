package realize;

import java.util.Stack;

/**
 * 栈实现队列
 * s1用于入栈，s2用于出栈
 */
class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * 入栈的值均放入到s1中
     */
    public void push(int x) {
        s1.push(x);
    }

    /**
     * 使用s2来进行出栈，即出队
     */
    public int pop() {
        //判空
        if (empty()) {
            return -1;
        }
        //若s2中无元素后，直接把s1中的元素放到s2中，然后弹出
        if (s2.empty()) {
            while (!s1.empty()) {
                //把s1中的元素放到s2中
                s2.push(s1.pop());
            }
        }
        //弹出s2中的元素
        return s2.pop();
    }

    public int peek() {
        if (empty()) {
            return -1;
        }
        if (s2.empty()) {
            while (!s1.empty()) {
                //把s1中的元素放到s2中
                s2.push(s1.pop());
            }
        }
        //弹出s2中的元素
        return s2.peek();
    }

    //判空
    public boolean empty() {
        return s1.empty() && s2.empty();
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