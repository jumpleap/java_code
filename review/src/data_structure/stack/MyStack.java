package data_structure.stack;

import java.util.Arrays;

/**
 * @Author 林沐雨
 * @Date 2025/4/29
 * @Description 模拟实现栈
 */
public class MyStack {
    private int[] arr;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        this.arr = new int[DEFAULT_CAPACITY];
    }

    public MyStack(int length) {
        this.arr = new int[length];
    }

    // 入栈
    public void push(int val) {
        if (size == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[size++] = val;
    }

    // 出栈
    public int pop() {
        if (empty()) {
            System.out.println("没有可出栈的元素!");
            return -1;
        }
        int oldVal = arr[size - 1];
        size--;
        return oldVal;
    }

    // 获取栈顶元素
    public int peek() {
        if (empty()) {
            System.out.println("没有可出栈的元素!");
            return -1;
        }
        return arr[size - 1];
    }

    // 判断栈是否为空
    public boolean empty() {
        return size == 0;
    }

    // 获取栈中元素个数
    public int size() {
        return size;
    }

    // 打印
    public void display() {
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
