package ds.seq_list;

import java.util.Arrays;

// 模拟实现顺序表
public class MyArrayList {
    // 底层数组默认大小
    private static final int DEFAULT_CAPACITY = 10;
    private int[] elem;
    // 累计数组中的元素个数
    private int usedSize;

    // 构造器
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        this.elem = new int[capacity];
    }

    // 添加数据
    public void add(int data) {
        // 判满
        if (usedSize == elem.length) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }
        // 添加元素到数组后面
        this.elem[usedSize++] = data;
    }

    // 根据下标添加数据
    public void add(int index, int data) {
        // 判断下标是否越界
        if (index < 0 || index > usedSize) {
            throw new IndexOfArrayException("下标异常: " + index);
        }

        // 判满
        if (usedSize == elem.length) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }

        // 把index处及其后面的下标往后移
        for (int i = usedSize; i > index; i--) {
            this.elem[i] = this.elem[i-1];
        }
        // 把要插入的元素放到index处
        this.elem[index] = data;
        usedSize++;
    }

    // 删除数据
    public void removeOfElement(int data) {
        // 获取待删除元素的下标
        int index = -1;
        for(int i = 0; i < usedSize; i++) {
            // 找到了要删除元素
            if(elem[i] == data) {
                // 获取下标
                index = i;
                break;
            }
        }
        // 没有找到
        if (index == -1) return;
        removeOfIndex(index);
    }

    // 根据下标删除数据
    public void removeOfIndex(int index) {
        // 判断下标是否越界
        if (index < 0 || index >= usedSize) {
            throw new IndexOfArrayException("下标异常: " + index);
        }

        // 把要删除下标的后面元素前移
        for (int i = index; i < usedSize - 1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        usedSize--;
    }

    // 删除顺序表中所有与给定数据相同的值
    public void remove(int data) {
        // 临时数组
        int[] tmp = new int[elem.length];
        int index = 0;

        // 将不同的元素放到tmp数组中
        for(int i = 0; i < usedSize; i++) {
            if (elem[i] != data) {
                tmp[index++] = elem[i];
            }
        }
        // 将删除重复元素后的数组重新赋给elem数组
        this.elem = tmp;
        // 重置有效元素个数
        usedSize = index;
    }

    // 获取给定值在顺序表中第一次出现的位置
    public int indexOf(int data) {
        for(int i = 0; i < usedSize; i++) {
            // 找到了
            if (elem[i] == data) {
                return i;
            }
        }
        return -1;
    }

    // 获取给定值在顺序表中最后一次出现的位置
    public int lastIndexOf(int data) {
        for (int i = usedSize - 1; i >= 0; i--) {
            // 找到了
            if (elem[i] == data) {
                return i;
            }
        }
        return -1;
    }

    // 判断给定值是否在顺序表中存在
    public boolean contains(int data) {
        for (int i = 0; i < usedSize; i++) {
            // 存在
            if (elem[i] == data) {
                return true;
            }
        }
        return false;
    }

    // 获取下标处的元素
    public int get(int index) {
        if (index < 0 || index >= usedSize) {
            throw new IndexOfArrayException("下标异常: " + index);
        }
        return elem[index];
    }

    // 更新下标的元素
    public void set(int index, int data) {
        if (index < 0 || index >= usedSize) {
            throw new IndexOfArrayException("下标异常: " + index);
        }
        elem[index] = data;
    }

    // 判断顺序表是否为空
    public boolean isEmpty() {
        return usedSize == 0;
    }

    // 获取顺序表的长度
    public int size() {
        return usedSize;
    }

    // 打印顺序表的值
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }

    // 清空顺序表
    public void clear() {
        this.elem = null;
        usedSize = 0;
    }
}
