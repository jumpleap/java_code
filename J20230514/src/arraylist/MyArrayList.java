package arraylist;


import java.util.Arrays;

public class MyArrayList {
    private int[] elem;
    private int usedSize;//0
    //默认容量
    private static final int DEFAULT_SIZE = 10;

    //默认初始化
    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
    }

    //按照自己给定的大小进行初始化
    public MyArrayList(int initCapacity) {
        this.elem = new int[initCapacity];
    }

    /**
     * 打印顺序表:
     * 根据usedSize判断即可
     */
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    // 新增元素,默认在数组最后新增
    public void add(int data) {
        checkCapacity();
        //把添加的元素放在最后一个，让有效长度自增
        this.elem[usedSize++] = data;
    }

    /**
     * 判断当前的顺序表是不是满的！
     */
    public void checkCapacity() {
        if (this.usedSize != this.elem.length) {
            return;
        }
        //扩容
        this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
    }

    //判断添加元素的位置是否合法
    private void checkPosInAdd(int pos) throws IndexOfArrayException {
        //判断下标是否合理
        if (pos < 0 || pos > usedSize) {
            throw new IndexOfArrayException("下标：" + pos + "，位置不合法！");
        }
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) throws IndexOfArrayException {
        checkPosInAdd(pos);
        checkCapacity();
        //把添加数据的元素后面的下标后移
        for (int i = usedSize - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int get(int pos) {
        checkPos(pos);
        return this.elem[pos];
    }

    //检查下标是否合理
    private void checkPos(int pos) {
        if (pos < 0 || pos >= this.usedSize) {
            throw new IndexOfArrayException("下标：" + pos + "，位置不合法！");
        }
    }

    public boolean isEmpty() {
        if (this.usedSize == 0) {
            return true;
        }
        return false;
    }

    // 给 pos 位置的元素设为【更新为】 value
    public void set(int pos, int value) {
        checkPos(pos);
        this.elem[pos] = value;
    }

    /**
     * 删除第一次出现的关键字key
     * @param key 关键字
     */
    public void remove(int key) {
        int index = indexOf(key);
        if (index == -1) {
            System.out.println("没有此元素！");
            return;
        }
        //删除这个元素
        for (int i = index; i < this.usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
        //引用类型
        //this.elem[usedSize-1] = null;
    }

    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
        //引用类型
        /*for (int i = 0; i < this.usedSize; i++) {
            this.elem[i] = null;
        }*/
    }
}