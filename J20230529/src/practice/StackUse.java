package practice;

import java.util.Stack;

/**
 * 栈的基本使用
 */
public class StackUse {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        //入栈
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        //出栈
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        //stack.pop();
        //stack.pop();

        //获取栈顶元素
        System.out.println(stack.peek());
        //判断栈是否为空
        System.out.println(stack.empty());
        //栈的长度
        System.out.println(stack.size());
    }
}