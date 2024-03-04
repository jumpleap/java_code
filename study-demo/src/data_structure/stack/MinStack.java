package data_structure.stack;

import java.util.Stack;

// 最小栈
class MinStack {
    // 正常的出入栈
    private Stack<Integer> stack;
    // 只出入最小值的栈
    private Stack<Integer> minStack;

    // 初始化
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * 入栈
     * stack进行正常的入栈
     * minStack为空时, 入栈; 不为空时, 比较栈顶元素是否比要入栈的值大, 大则入栈
     */
    public void push(int val) {
        // 入栈
        stack.push(val);

        // 栈空判读
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else if (minStack.peek() >= val) {
            // 判断minStack的栈顶元素是否比val大
            minStack.push(val);
        }
    }

    /**
     * 出栈
     * stack正常出栈
     * minStack出栈需要判断栈顶元素是否和stack出栈的元素是否相同, 相同则出栈
     */
    public void pop() {
        // stack出栈
        int val = stack.pop();
        // 判断val是否和minStack栈顶元素值是否相同
        if (val == minStack.peek()) {
            // 相同出栈
            minStack.pop();
        }
    }

    /**
     * 获取stack栈的栈顶元素
     */
    public int top() {
        // 栈空
        if (stack.isEmpty()) return -1;
        // 返回栈顶元素
        return stack.peek();
    }

    /**
     * 获取最小栈的栈顶元素
     */
    public int getMin() {
        // 栈空
        if (minStack.isEmpty()) return -1;
        // 返回最小栈的栈顶元素
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