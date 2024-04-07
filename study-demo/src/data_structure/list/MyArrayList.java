package data_structure.list;

import java.util.Arrays;

// 模拟实现顺序表
public class MyArrayList {
    // 底层数组
    private int[] array;
    // 数组中的有效长度
    private int size;
    // 默认大小
    private final static int DEFAULT_CAPACITY = 2;

    /**
     * 无参构造器
     */
    public MyArrayList() {
        array = new int[DEFAULT_CAPACITY];
    }

    /**
     * 有参构造器
     */
    public MyArrayList(int capacity) {
        array = new int[capacity];
    }

    /**
     * 新增元素,默认在数组最后新增
     */
    public void add(int data) {
        // 判满
        isFull();
        // 添加元素
        array[size++] = data;
    }

    /**
     * 数组判满
     */
    private void isFull() {
        // 数组满了
        if (size == array.length) {
            // 数组扩容
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    /**
     * 在 pos 位置新增元素
     */
    public void add(int pos, int data) {
        // 判断pos是否合理
        isLegalIndex(pos);
        // 判满
        isFull();

        // 把pos后的元素后移
        for (int i = size; i > pos; i--) {
            array[i] = array[i - 1];
        }
        // 添加pos处的元素
        array[pos] = data;
        // 长度自增
        size++;
    }

    /**
     * 判断下标是否合理
     */
    private void isLegalIndex(int pos) {
        // 判断pos位置是否合理
        if (pos < 0 || pos > size) {
            throw new IndexException("pos下标异常: " + pos);
        }
    }

    /**
     * 判定是否包含某个元素
     */
    public boolean contains(int data) {
        for (int i = 0; i < size; i++) {
            if (data == array[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找某个元素对应的位置
     */
    public int indexOf(int data) {
        for (int i = 0; i < size; i++) {
            if (data == array[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取 pos 位置的元素
     */
    public int get(int pos) {
        // 判断pos位置是否合理
        isLegalIndex(pos);
        return array[pos];
    }

    /**
     * 给 pos 位置的元素设为 value
     */
    public void set(int pos, int value) {
        // 判断pos位置是否合理
        isLegalIndex(pos);
        // 更新值
        array[pos] = value;
    }

    /**
     * 删除第一次出现的关键字key
     */
    public void remove(int data) {
        // 获取data元素的下标
        int index = indexOf(data);
        if (index == -1) {
            System.out.println("无此元素!");
            return;
        }

        // 把index处后的元素前移
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        // 长度自减
        size--;
    }

    /**
     * 获取顺序表长度
     */
    public int size() {
        return size;
    }

    /**
     * 打印值
     */
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * 清空顺序表
     */
    public void clear() {
        array = null;
        size = 0;
    }
}