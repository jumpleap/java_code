package map_set;

/**
 * 哈希表 + 双向链表的简单实现
 */
public class HashBucket {
    static class Node {
        private int key;
        private int val;
        private Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] array;
    private int usedSize;//数组有效长度
    private static final int DEFAULT_CAPACITY = 10;//默认长度

    public HashBucket() {
        array = new Node[DEFAULT_CAPACITY];//申请数组空间
    }

    /**
     * 插入新的key-val值，若存在，则更新val值
     * @param key key值
     * @param val val值
     */
    public void put(int key, int val) {
        int index = key % array.length;//获取放入的哈希表的下标
        Node cur = array[index];//把待放入的值放在该元素的链表后面

        //查找链表中是否存在待放入的key
        while (cur != null) {
            //存在相同的key
            if (cur.key == key) {
                cur.val = val;//更新节点的val值
                return;
            }
            cur = cur.next;
        }

        //不存在相同的key
        Node node = new Node(key, val);//申请节点
        //头插
        node.next = array[index];
        array[index] = node;
        usedSize++;

        //判断加载因子是否超过0.75
        if (loadFactor() >= 0.75) {
            resize();
        }
    }

    /**
     * 扩容
     */
    private void resize() {
        Node[] tmpArr = new Node[array.length * 2];//扩容
        //遍历原来的数组，将所有的元素 --> 重新哈希到新数组中
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            //遍历链表
            while (cur != null) {
                //记录当前节点的下个节点
                Node curNext = cur.next;
                int index = cur.key % tmpArr.length;//重新哈希
                //头插
                cur.next = tmpArr[index];
                tmpArr[index] = cur;

                cur = curNext;
            }
        }
        array = tmpArr;
    }

    /**
     * 通过key获取val
     * @param key key值
     * @return 返回val值
     */
    public int get(int key) {
        //通过哈希找到了对应的key所在的链表
        int index = key % array.length;
        Node cur = array[index];

        while (cur != null) {
            //找到了对应的key
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;//没有找到的情况
    }

    /**
     * 计算加载因子
     * @return 返回加载因子
     */
    private double loadFactor() {
        return usedSize * 1.0 / array.length;
    }
}