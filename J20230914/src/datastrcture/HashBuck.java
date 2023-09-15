package datastrcture;

/**
 * 哈希的基本实现
 */
public class HashBuck {
    //定义节点类
    static class Node {
        private int key;
        private int val;
        private Node next;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] array;
    private int useSize;
    private final static int DEFAULT_LENGTH = 10;

    public HashBuck() {
        array = new Node[DEFAULT_LENGTH];
    }

    public void put(int key, int val) {
        //进行哈希
        int index = key % array.length;
        //找到哈希后的对应值
        Node cur = array[index];

        //遍历一遍链表判断是否值存在链表中
        while (cur != null) {
            //key不能重复, val可以重复
            if (cur.key == key) {
                //更新val
                cur.val = val;
                return;
            }
            cur = cur.next;
        }

        //没有重复的值
        Node node = new Node(key, val);
        //头插法
        node.next = array[index];
        array[index] = node;
        useSize++;

        //加载因子, 超过了需要扩容
        if (loadFactor() >= 0.75) {
            //扩容
            resize();
        }
    }

    private void resize() {
        //临时数组
        Node[] tmp = new Node[array.length * 2];

        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                //记录当前位置的下一个位置
                Node curNext = cur.next;
                //重新哈希
                int newIndex = cur.key % tmp.length;
                //头插法
                cur.next = tmp[newIndex];
                tmp[newIndex] = cur;
                cur = curNext;
            }
        }
        array = tmp;
    }

    private double loadFactor() {
        return useSize * 1.0 / array.length;
    }

    public int get(int key) {
        //根据哈希后的值找打对应数组的位置
        int index = key % array.length;
        Node cur = array[index];

        //遍历链表
        while (cur != null) {
            //找到了,返回对应的value
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        //没找到
        return -1;
    }

}