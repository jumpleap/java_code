package data_struct;

import java.util.Arrays;

public class MyArrayList {
    private int[] element;
    private int usedSize;
    private static final int DEFAULT_CAPACITY = 2; //默认长度

    public MyArrayList() {
        this.element = new int[DEFAULT_CAPACITY];
    }

    /**
     * 给定容量
     */
    public MyArrayList(int initCapacity) {
        this.element = new int[initCapacity];
    }

    /**
     * 添加元素, 把元素添加到数组最后
     */
    public void add(int val) {
        //判满
        if (isFull()) {
            //扩容
            this.element = Arrays.copyOf(this.element, this.element.length * 2);
        }
        //把元素插入到数组的最后
        this.element[usedSize++] = val;
    }

    private boolean isFull() {
        //满了返回true
        return this.element.length == usedSize;
    }

    /**
     * 在指定位置插入元素
     */
    public void add(int index, int val) {
        //判断插入的位置是否合理
        if (index < 0 || index > this.usedSize) {
            throw new IndexOfBoundException("下标:" + index + "出错!");
        }

        //判满
        if (isFull()) {
            //扩容
            this.element = Arrays.copyOf(this.element, this.element.length * 2);
        }

        //把要插入位置之后的元素全部后移,留出插入位置
        for (int i = usedSize - 1; i >= index; i--) {
            this.element[i + 1] = this.element[i];
        }
        this.element[index] = val;
        this.usedSize++;
    }

    /**
     * 删除第一次出现的元素
     */
    public void remove(int value) {
        //判空
        if (isEmpty()) {
            throw new ArrayIsEmptyException("数组为空!");
        }

        //元素不在数组中
        int index = indexOf(value);
        if (index == -1) {
            System.out.println("元素不存在");
            return;
        }

        //删除元素,需要把该元素之后的元素进行前移
        for (int i = index; i < this.usedSize - 1; i++) {
            this.element[i] = this.element[i + 1];
        }
        this.usedSize--;
    }

    /**
     * 判断给定元素是否在数组中存在
     */
    public boolean contains(int value) {
        for (int i = 0; i < this.usedSize; i++) {
            //找到了
            if (this.element[i] == value) { //注意, 在引用类型中使用equals进行比较
                return true;
            }
        }
        //没找到
        return false;
    }

    /**
     * 查找给定元素在数组中第一次出现的下标
     */
    public int indexOf(int value) {
        for (int i = 0; i < this.usedSize; i++) {
            //找到了
            if (this.element[i] == value) {
                return i;
            }
        }
        //没找到
        return -1;
    }

    /**
     * 获取给定下标处的元素
     */
    public int get(int index) {
        //判断给定的下标是否合法
        checkIndex(index);
        return this.element[index];
    }

    /**
     * 把给定下标处的元素更新
     */
    public void set(int index, int value) {
        //判断给定的下标是否合法
        checkIndex(index);
        this.element[index] = value;
    }

    /**
     * 检查下标是否合法
     */
    private void checkIndex(int index) {
        if (index < 0 || index > this.usedSize - 1) {
            throw new IndexOfBoundException("下标:" + index + "出错!");
        }
    }

    /**
     * 判断数组是否为空
     */
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    /**
     * 获取数组的长度
     */
    public int size() {
        return this.usedSize;
    }

    /**
     * 打印数组中的内容
     */
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(element[i] + " ");
        }
        System.out.println();
    }

    /**
     * 清空顺序表
     */
    public void clear() {
        /*
        //引用类型需要把每一个值都释放掉
        for (int i = 0; i < this.usedSize; i++) {
            this.element[i] = null;
        }
        */
        this.usedSize = 0;
    }
}