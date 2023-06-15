package leetcode;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
class MinStack {
    Stack<Integer> stack;//正常栈
    Stack<Integer> minStack;//最小栈

    /**
     * 初始化
     */
    public MinStack() {
        //初始化
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * 入栈
     */
    public void push(int val) {
        //正常入栈
        stack.push(val);
        //最小栈为空即入栈
        if (minStack.empty()) {
            minStack.push(val);
            return;
        }

        //val比最小栈的栈顶值小则入栈
        if (val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    /**
     * 出栈
     */
    public void pop() {
        //判断是否栈空
        if (stack.empty()) {
            return;
        }

        //正常栈必须弹出，最小栈的栈顶值和正常栈的值相同，弹出
        int ret = stack.pop();
        if (ret == minStack.peek()) {
            minStack.pop();
        }
    }

    /**
     * 栈顶元素
     */
    public int top() {
        //获取正常栈的栈顶
        return stack.peek();
    }

    /**
     * 最下的栈顶元素
     */
    public int getMin() {
        //最小栈为空
        if (minStack.empty()) {
            return -1;
        }
        //返回最小栈的栈顶元素
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