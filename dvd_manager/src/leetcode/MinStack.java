package leetcode;

import java.util.Stack;

class MinStack {
    Stack<Integer> normal;//正常栈
    Stack<Integer> min;//最小栈

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        //进行初始化
        normal = new Stack<>();
        min = new Stack<>();
    }

    //入栈
    public void push(int x) {
        normal.push(x);
        if (min.empty()) {
            min.push(x);
            return;
        }
        //判断x的值是否小于最小栈的栈顶值
        if (x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        int x = normal.pop();
        //如果正常栈出栈的值和最小栈的值相同，那么一起出栈
        if (x == min.peek()) {
            min.pop();
        }
    }

    //获取正常栈的栈顶元素
    public int top() {
        return normal.peek();
    }

    //获取最小栈的栈顶元素
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */