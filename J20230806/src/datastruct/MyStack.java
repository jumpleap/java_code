package datastruct;

import java.util.Arrays;
/**
 * 栈顶模拟实现
 */
public class MyStack {
    private int[] elem;
    //计算数组的长度
    private int usedSize;
    //数组默认大小
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        //给数组分配默认的大小的空间
        this.elem = new int[DEFAULT_CAPACITY];
    }

    /**
     * 入栈
     * @param val 待入栈的值
     */
    public void push(int val) {
        //判断数组是否满了
        if (isFull()) {
            this.elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        this.elem[usedSize++] = val;
    }

    /**
     * 判断空间是否满了
     * @return true/false
     */
    private boolean isFull() {
        return usedSize == this.elem.length;
    }

    /**
     * 出栈
     * @return 返回栈顶元素并删除
     */
    public int pop() {
        //判空
        if (isEmpty()) {
            throw new EmptyArrayException("数组中没有数据！");
        }
        //弹出栈顶元素
        return this.elem[--usedSize];
    }

    /**
     * 判断数组是否为空
     * @return 返回true/false
     */
    public boolean isEmpty() {
        return usedSize == 0;
    }

    /**
     * 获取栈顶元素【不删除】
     * @return 返回栈顶元素的值
     */
    public int peek() {
        //判空
        if (isEmpty()) {
            throw new EmptyArrayException("数组中没有数据！");
        }
        //获取栈顶元素不删除
        return this.elem[usedSize - 1];
    }
}