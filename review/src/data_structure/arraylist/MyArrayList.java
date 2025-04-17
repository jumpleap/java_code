package data_structure.arraylist;

import java.util.Arrays;

/**
 * @Author 林沐雨
 * @Date 2025/4/16
 * @Description 模拟顺序表
 */
public class MyArrayList {
    private int[] elem;
    // 计数器：计算数组中有效元素个数
    private int size;
    // 数组默认大小
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 创建无参和有参构造器
     */
    public MyArrayList() {
        this.elem = new int[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        this.elem = new int[capacity];
    }

    /**
     * 操作
     */

    // 插入元素到数组尾部
    public void add(int val) {
        // 判满
        if (this.size == this.elem.length) {
            // 扩容
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }

        // 把元素插入到数组最后，size指向下一个位置
        this.elem[size++] = val;
    }

    // 插入元素到指定位置
    public void add(int index, int val) {
        // 判断插入的下标是否合理
        if (index < 0 || index > size) {
            throw new IndexOfBoundsException("下标不合法：" + index);
        }

        // 判满
        if (this.size == this.elem.length) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }

        // 插入元素到指定位置
        for (int i = this.size - 1; i >= index; i--) {
            // 元素后移
            this.elem[i + 1] = this.elem[i];
        }

        // 把val插入到index处
        this.elem[index] = val;
        // 有效个数+1
        this.size++;
    }

    // 删除指定元素
    public void remove(int val) {
        // 找到元素第一次出现的下标
        int index = indexOf(val);

        // 元素不存在
        if (index == -1) {
            System.out.println("元素不存在！");
            return;
        }

        // 进行元素的删除
        for (int i = index; i < this.size - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        // 有效元素个数-1
        this.size--;
    }

    // 更新指定位置的元素
    public void set(int index, int val) {
        if (index < 0 || index >= this.size) {
            throw new IndexOfBoundsException("下标不合法：" + index);
        }
        // 更新
        this.elem[index] = val;
    }

    // 获取指定位置的元素
    public int get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOfBoundsException("下标不合法：" + index);
        }
        return this.elem[index];
    }

    // 查找元素第一次出现的位置
    public int indexOf(int val) {
        for (int i = 0; i < this.size; i++) {
            if (val == this.elem[i]) {
                return i;
            }
        }
        // 返回结果：-1没有找到
        return -1;
    }

    // 查找元素最后一次出现的位置
    public int lastIndexOf(int val) {
        for (int i = this.size - 1; i >= 0; i--) {
            if (val == this.elem[i]) {
                return i;
            }
        }
        return -1;
    }

    // 判断数组中是否包含给定元素
    public boolean contains(int val) {
        for (int i = 0; i < this.elem.length; i++) {
            if (val == this.elem[i]) {
                return true;
            }
        }
        return false;
    }

    // 打印数组中的内容
    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    // 清空数组
    public void clear() {
        this.size = 0;
    }
}
