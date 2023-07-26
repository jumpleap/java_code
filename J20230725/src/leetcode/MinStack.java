package leetcode;

import java.util.Stack;

/*
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class MinStack {

    /**
     * initialize your data structure here.
     */
    Stack<Integer> stack;//正常栈
    Stack<Integer> min;//最小栈

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        //判断stack和min是否都为空栈
        if (stack.empty() && min.empty()) {
            //都是空栈则都入栈
            stack.push(x);
            min.push(x);
            return;
        }
        stack.push(x);
        //判断入的值是否小于等于最小栈的值
        if (x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        //正常栈出栈
        int ret = stack.pop();
        //若是出栈的值和最小栈的值相同，最小栈也要出栈
        if (ret == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        //正常栈的栈顶元素
        return stack.peek();
    }

    public int min() {
        //最小栈的栈顶元素
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */