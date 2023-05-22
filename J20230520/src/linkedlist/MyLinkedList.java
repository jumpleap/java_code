package linkedlist;

import linklist.IndexOfBoundsException;

public class MyLinkedList {
    static class ListNode {
        private int val;
        private ListNode prev;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;
    public ListNode tail;

    //得到单链表的长度
    public int size() {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void display() {
        if (head == null) {
            return;
        }

        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //删除第一次出现关键字为key的节点
    public boolean remove(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        checkIndex(index);
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (data == this.size()) {
            addLast(data);
            return;
        }

        ListNode cur = head;
        ListNode node = new ListNode(data);
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }

        node.next = cur.next;
        cur.prev = node;
        node.prev = cur;
        cur.next = node;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOfBoundsException("index 不合法！" + index);
        }
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        return false;
    }


    //删除所有值为key的节点
    public void removeAllKey(int key) {
    }


    public void clear() {
    }
}
