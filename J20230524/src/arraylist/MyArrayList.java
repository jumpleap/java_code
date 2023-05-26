package arraylist;

import java.util.Arrays;

public class MyArrayList {
    private int[] elem;
    private int usedSize;//有效长度

    private static final int DEFAULT_CAPACITY = 10;//默认大小

    public MyArrayList() {
        //给数组进行默认初始化
        this.elem = new int[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        this.elem = new int[capacity];
    }


    /**
     * 各种操作方法
     */

    //添加元素
    public void add(int data) {
        isFull();//判断数组是否满了，满了则扩容
        this.elem[this.usedSize++] = data;
    }

    //判断顺序表是否满了
    private void isFull() {
        if (this.elem.length == this.usedSize) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }
    }

    //在任意位置插入元素
    public void add(int pos, int data) {
        //检查下标
        if (pos < 0 || pos > this.usedSize) {
            throw new PosInsertException("插入位置异常！");
        }
        isFull();//检查顺序表是否需要扩容

        //插入位置元素的后面元素后移
        for (int i = this.usedSize - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        //插入你要插入的数据
        this.elem[pos] = data;
        this.usedSize++;
    }

    //查看顺序表中是否包含某个元素
    public boolean contains(int key) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == key) {
                return true;
            }
        }
        return false;
    }

    //查找某元素第一次出现的位置
    public int indexOf(int num) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == num) {
                return i;
            }
        }
        return -1;//没有找到
    }

    //获取pos位置的元素
    public int get(int pos) {
        checkPos(pos);
        return this.elem[pos];
    }

    //检查插入的位置的合法性
    private void checkPos(int pos) throws PosInsertException {
        if (pos < 0 || pos >= this.usedSize) {
            throw new PosInsertException("pos" + pos + "+位置异常！");
        }
    }

    //给pos位置的元素更新
    public void set(int pos, int value) {
        checkPos(pos);
        if (isEmpty()) {
            throw new MyArrayListIsEmptyException("顺序表为空~");
        }
        this.elem[pos] = value;
    }

    //删除顺序表中第一次和key相同的元素
    public void remove(int key) {
        //判断顺序表是否为空
        if (isEmpty()) {
            throw new MyArrayListIsEmptyException("顺序表为空~");
        }

        int index = indexOf(key);//查找该元素在顺序表中第一次出现的位置
        if (index == -1) {
            System.out.println("顺序表中无此元素~");
            return;
        }

        //数组元素进行前移
        for (int i = index; i < this.usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
    }

    //判断顺序表是否为空
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    //获取顺序表的长度
    public int size() {
        return this.usedSize;
    }

    //打印顺序表中的内容
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    //清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}