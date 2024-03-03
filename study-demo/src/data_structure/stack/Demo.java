package data_structure.stack;

import java.util.Stack;

// 栈的使用
public class Demo {
    public static void main(String[] args) {
        // 创建栈
        Stack<Integer> stack = new Stack<>();
        // 入栈
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

        // 出栈
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);

        // 获取栈顶元素
        System.out.println(stack.peek());

        // 获取栈中元素个数
        System.out.println(stack.size());

        // 判断栈是否为空
        System.out.println(stack.isEmpty());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());
    }
}
