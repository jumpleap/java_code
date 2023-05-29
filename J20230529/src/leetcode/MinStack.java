package leetcode;

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        //进行初始化
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    //入栈
    public void push(int val) {
        //stack入栈
        stack.push(val);
        //判断minStack是不是第一次入栈
        if (minStack.empty()) {
            minStack.push(val);
            return;
        }

        //判断后续的值是否为小值
        if (val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    //出栈
    public void pop() {
        //判断stack是否非空
        if (!stack.empty()) {
            int ret = stack.pop();//弹出stack的值
            //进行比较，相等则把minStack的值也弹出
            if (ret == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    //获取栈顶元素
    public int top() {
        if (!stack.empty()) {
            return stack.peek();
        }
        return -1;
    }

    //或者最小栈的栈顶元素
    public int getMin() {
        if (minStack.empty()) {
            return -1;
        }
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */