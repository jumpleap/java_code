package data_sructure;

import java.util.Arrays;

// 栈的模拟实现
public class MyStack {
    private int[] elements;
    private int usedSize;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    public MyStack(int size) {
        this.elements = new int[size];
    }


    /**
     * 入栈
     */
    public void push(int val) {
        // 扩容
        grow();
        elements[usedSize++] = val;
    }

    /**
     * 扩容
     */
    private void grow() {
        // 数组满了则需要扩容
        if (this.usedSize == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    /**
     * 出栈
     */
    public int pop() {
        // 判空
        isNUll();
        return elements[--usedSize];
    }

    /**
     * 获取栈顶元素
     */
    public int peek() {
        // 判空
        isNUll();
        return elements[usedSize - 1];

    }

    /**
     * 对empty()进行封装
     */
    private void isNUll() {
        if (empty()) {
            throw new StackIsNullException("栈为空, 无法出栈!");
        }
    }

    /**
     * 栈空判断
     */
    public boolean empty() {
        return usedSize == 0;
    }

    /**
     * 获取栈的长度
     */
    public int size() {
        return usedSize;
    }
}