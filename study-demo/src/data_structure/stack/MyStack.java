package data_structure.stack;

import java.util.Arrays;

// 栈的模拟实现
public class MyStack {
    // 创建数组, 实现栈的基础
    private int[] elem;
    // 栈的使用长度
    private int usedSize;

    // 栈的默认大小
    private static final int DEFAULT_CAPACITY = 10;

    // 构造器
    public MyStack() {
        this.elem = new int[DEFAULT_CAPACITY];
    }

    public MyStack(int size) {
        this.elem = new int[size];
    }

    /**
     * 入栈
     */
    public void push(int val) {
        // 判满
        if (isFull()) {
            // 扩容
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        // 把入栈的元素放到最后一个位置, 然后有效长度自增
        this.elem[usedSize++] = val;
    }

    /**
     * 判断栈满
     */
    private boolean isFull() {
        // 判断使用长度是否和数组长度相等
        return this.usedSize == this.elem.length;
    }

    /**
     * 出栈
     */
    public int pop() {
        // 判空
        if (isEmpty()) {
            // 抛出异常
            throw new NullStackException("栈为空, 请添加元素后重试!");
        }
        // 返回栈顶元素
        return this.elem[--usedSize];
    }

    /**
     * 判断栈空
     */
    private boolean isEmpty() {
        return this.usedSize == 0;
    }

    /**
     * 获取栈顶元素
     */
    public int peek() {
        // 判空
        if (isEmpty()) {
            throw new NullStackException("栈为空, 请添加元素后重试!");
        }
        return this.elem[usedSize - 1];
    }
}
