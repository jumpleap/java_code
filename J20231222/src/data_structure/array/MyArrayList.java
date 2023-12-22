package data_structure.array;

import java.util.Arrays;

// 顺序表的模拟实现
public class MyArrayList {
    // 数组
    private int[] elem;
    // 有效元素个数
    private int usedSize;
    // 默认数组长度
    private static final int DEFAULT_CAPACITY = 5;

    // 构造器
    public MyArrayList() {
        this.elem = new int[DEFAULT_CAPACITY];
    }

    public MyArrayList(int size) {
        this.elem = new int[size];
    }


    // 插入数据
    public void insert(int data) {
        // 判断数组是否已满
        if (this.usedSize == elem.length) {
            // 满了进行扩容
            grow();
        }

        this.elem[usedSize++] = data;
    }

    // 在指定位置插入元素
    public void insert(int index, int data) {
        // 判断数组是否已满
        if (this.usedSize == elem.length) {
            // 满了进行扩容
            grow();
        }

        // 判断要插入位置是否正确
        judgeOfInsert(index);

        // index处的元素后移
        for (int i = usedSize - 1; i >= index; i--) {
            this.elem[i + 1] = this.elem[i];
        }

        // 插入
        this.elem[index] = data;
        usedSize++;
    }

    // 数组扩容
    private void grow() {
        this.elem = Arrays.copyOf(this.elem, elem.length * 2);
    }

    // 判断下标是否合法
    private void judgeOfInsert(int index) {
        if (index < 0 || index > usedSize) {
            throw new IndexOfException("下标错误: " + index);
        }
    }

    // 删除第一次和target相等的元素
    public void remove(int target) {
        int index = indexOf(target);

        if (index == -1) {
            System.out.println("该元素不存在!");
            return;
        }

        for (int i = index; i < usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        // 若是Object类型的话, 需要把最后一个元素置为null
        // this.elem[usedSize - 1] = null;
        usedSize--;
    }

    // 判断下标是否合法
    private void judgeOfRemove(int index) {
        if (index < 0 || index >= usedSize) {
            throw new IndexOfException("下标错误: " + index);
        }
    }

    // 查找特定元素
    public boolean contains(int target) {
        for (int i = 0; i < this.usedSize; i++) {
            if (target == elem[i]) {
                return true;
            }
        }
        // 没找到
        return false;
    }

    // 返回查找到第一个元素的下标
    public int indexOf(int target) {
        for (int i = 0; i < usedSize; i++) {
            if (target == elem[i]) {
                return i;
            }
        }
        // 不存在
        return -1;
    }

    // 获取index处的元素
    public int get(int index) {
        judgeOfRemove(index);
        return elem[index];
    }

    // 获取顺序表长度
    public int size() {
        return usedSize;
    }

    // 打印数组内容
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }


    // 清空顺序表
    public void clear() {
        /*for (int i = 0; i < usedSize; i++) {
            this.elem[i] = null;
        }*/
        usedSize = 0;
        this.elem = null;
    }
}
