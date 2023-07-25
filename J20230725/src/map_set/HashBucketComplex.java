package map_set;

import java.util.Objects;

/**
 * 哈希表 + 双向链表的泛型实现
 */
public class HashBucketComplex<K, V> {
    static class Node<K, V> {
        private K key;
        private V val;
        private Node<K, V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node<K, V>[] array;
    private int usedSize;
    private static final int DEFAULT_CAPACITY = 10;//默认长度

    public HashBucketComplex() {
        array = new Node[DEFAULT_CAPACITY];
    }

    /**
     * 插入新的key-val值，若存在，则更新val值
     * @param key key值
     * @param val val值
     */
    public void put(K key, V val) {
        //获取哈希值找到对应的链表
        int hash = key.hashCode();
        int index = hash % array.length;

        Node<K, V> cur = array[index];
        //遍历链表
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.val = val;//更新节点值
                return;
            }
            cur = cur.next;
        }

        Node<K, V> node = new Node<>(key, val);
        //头插法
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
        Node<K, V>[] tmpArr = new Node[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            Node<K, V> cur = array[i];

            while (cur != null) {
                Node<K, V> curNext = cur.next;
                int index = cur.hashCode();
                //头插
                cur.next = tmpArr[index];
                tmpArr[index] = cur;
                cur = curNext;
            }
        }
        array = tmpArr;
    }

    /**
     * 计算加载因子
     * @return 返回加载因子
     */
    private double loadFactor() {
        return usedSize * 1.0 / array.length;
    }

    /**
     * 通过key获取val
     * @param key key值
     * @return 返回val值
     */
    public V get(K key) {
        int index = key.hashCode() % array.length;
        Node<K, V> cur = array[index];

        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.val;
            }
            cur = cur.next;
        }
        return null;//没有对应的key
    }
}

class Person {
    String id;

    public Person(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}