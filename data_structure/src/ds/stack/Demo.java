package ds.stack;

import java.util.Stack;

// 栈
public class Demo {
    public static void main(String[] args) {
        // 初始化
        Stack<Integer> stack = new Stack<>();

        // 入栈
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);

        // 出栈
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

        // 获取栈顶元素
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());

        // 判断栈是否为空
        System.out.println(stack.empty());
    }
}
