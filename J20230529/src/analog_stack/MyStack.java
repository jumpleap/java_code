package analog_stack;

import java.util.Arrays;

/**
 * 模拟实现栈
 * 栈的特点：后进先出
 */
public class MyStack {
    private int[] elem;
    private int usedSize;//有效长度

    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        //默认大小
        this.elem = new int[DEFAULT_CAPACITY];
    }

    /**
     * 入栈
     *
     * @param val 值
     */
    public int push(int val) {
        //判断是否满了
        checkCapacity();
        this.elem[this.usedSize++] = val;
        return val;
    }

    /**
     * 判断栈是否满了
     */
    private void checkCapacity() {
        //满了则扩容
        if (this.usedSize == this.elem.length) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }
    }

    /**
     * 出栈
     */
    public int pop() {
        //判断是否栈空
        if (isEmpty()) {
            throw new StackIsNullException("栈为空！");
        }
        int oldValue = peek();
        //删掉栈顶元素
        --this.usedSize;
        return oldValue;
    }

    /**
     * 获取栈顶元素
     */
    public int peek() {
        if (isEmpty()) {
            throw new StackIsNullException("栈为空！");
        }
        //返回栈顶元素
        return this.elem[this.usedSize - 1];
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    /**
     * 栈的元素个数
     */
    public int size() {
        return this.usedSize;
    }

    /**
     * 打印栈中的元素
     */
    public void display() {
        if (isEmpty()) {
            throw new StackIsNullException("栈为空！");
        }

        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
}