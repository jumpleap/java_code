package stack;

import java.util.Arrays;

public class MyStack {
    private int[] elem;
    private int usedSize;

    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        this.elem = new int[DEFAULT_CAPACITY];
    }

    public void push(int val) {
        //判断是否满了
        if (isFull()) {
            this.elem = Arrays.copyOf(elem, elem.length * 2);
        }
        this.elem[usedSize++] = val;
    }

    private boolean isFull() {
        return this.elem.length == this.size();
    }

    public int size() {
        return this.usedSize;
    }

    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("没有要删除的元素~");
        }
        int ret = this.elem[this.usedSize - 1];
        this.usedSize--;
        return ret;
    }

    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("没有栈顶元素~");
        }
        return this.elem[this.usedSize - 1];
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }
}