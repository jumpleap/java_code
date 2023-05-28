package stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if(stack.empty()) {
            stack.push(val);
            minStack.push(val);
            return;
        }

        stack.push(val);
        if(val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {

    }

    public int top() {
        return -1;
    }

    public int getMin() {
        return -1;
    }
}