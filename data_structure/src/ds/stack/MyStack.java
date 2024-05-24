package ds.stack;

import java.util.Arrays;

// 模拟栈的实现
public class MyStack {
    private int[] elem;
    // 有效元素个数
    private int usedSize;
    // 默认空间大小
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    public MyStack(int capacity) {
        this.elem = new int[capacity];
    }

    // 入栈
    public void push(int val) {
        // 判断栈满
        if (usedSize == elem.length) {
            elem = Arrays.copyOf(elem, elem.length * 2);
        }
        // 把元素入栈
        elem[usedSize++] = val;
    }

    // 出栈
    public int pop() {
        // 栈空
        if (empty()) {
            throw new StackIsEmpty("栈为空，无法出栈!");
        }

        // 获取栈顶元素
        int oldVal = elem[usedSize - 1];
        // 自减
        usedSize--;
        return oldVal;
    }

    // 获取栈顶元素
    public int peek() {
        // 栈空
        if (empty()) {
            throw new StackIsEmpty("栈空，无法获取栈顶元素！");
        }
        return elem[usedSize - 1];
    }

    // 判断栈是否为空
    public boolean empty() {
        return usedSize == 0;
    }

    public int size() {
        return usedSize;
    }

    // 打印元素
    public void display() {
        // 从栈顶开始打印， 一直到栈尾
        for (int i = usedSize - 1; i >= 0; i--) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }
}
