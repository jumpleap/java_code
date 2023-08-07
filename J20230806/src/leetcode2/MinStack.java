package leetcode2;

import java.util.Stack;

class MinStack {
    //申请栈
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * 入栈
     * 最小栈入栈需要判断val的值是否小于等于最小栈的栈顶元素
     * @param val 待入栈的值
     */
    public void push(int val) {
        stack.push(val);//普通栈正常入栈
        //最小栈为空入栈
        if (minStack.isEmpty()) {
            minStack.push(val);
            return;
        }

        //判读是否给最小栈入栈
        if (val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    /**
     * 出栈：若是普通栈的栈顶元素和最小栈的栈顶元素值相等，那么两个一起出栈，否则只需要出普通栈
     */
    public void pop() {
        int tmp = stack.pop();//出葡萄栈
        //判断最小栈是否需要出栈
        if (tmp == minStack.peek()) {
            minStack.pop();
        }
    }

    /**
     * 获取普通栈的栈顶元素，若普通栈为空，那么返回-1
     * @return 返回值
     */
    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    /**
     * 返回最小栈的栈顶元素，若最小栈为空，那么返回-1
     * @return 返回值
     */
    public int getMin() {
        if (minStack.isEmpty()) {
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