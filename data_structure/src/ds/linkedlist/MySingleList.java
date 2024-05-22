package ds.linkedlist;

import leetcode.util.ListNode;

// 单链表的模拟实现
public class MySingleList {
    // 指定头节点
    private ListNode head;

    // 头插
    public void headInsert(int data) {
        // 申请节点
        ListNode node = new ListNode(data);

        // 头节点判空
        if (head == null) {
            head = node;
            return;
        }

        // 头插
        node.next = head;
        head = node;
    }

    // 尾插
    public void tailInsert(int data) {
        // 申请节点
        ListNode node = new ListNode(data);

        // 判空
        if (head == null) {
            head = node;
            return;
        }

        ListNode cur = head;
        // 找到最后一个节点的位置
        while (cur.next != null) {
            cur = cur.next;
        }
        // 把要插入的节点放到后面
        cur.next = node;
    }

    // 给定位置插入
    public void insert(int index, int data) {
        // 判断下标
        if (index < 0 || index > size()) {
            throw new IndexOfException("下标异常: " + index);
        }

        // 判断头插
        if (index == 0) {
            headInsert(data);
            return;
        }

        // 判断尾插
        if (index == size()) {
            tailInsert(data);
            return;
        }

        // 申请节点
        ListNode node = new ListNode(data);
        ListNode cur = head;
        // 获取要插入位置的前一个节点
        ListNode prev = null;

        // 找到要插入的位置
        while (index > 0) {
            prev = cur;
            cur = cur.next;
            index--;
        }

        // 连接
        node.next = cur;
        prev.next = node;
    }

    // 删除给定值对应的节点
    public void removeOfData(int data) {
        // 判空
        if (head == null) return;

        // 判断头节点是否和data值相同
        if (head.val == data) {
            head = head.next;
            return;
        }

        // 查找当前值的节点
        ListNode cur = head.next;
        // 前驱节点, 用于删除cur指向的节点
        ListNode prev = head;
        while (cur != null) {
            // 当cur的节点值和data相同, prev获取cur的下一个节点
            if (cur.val == data) {
                // 跳过cur节点, 指向他的下一个节点
                prev.next = cur.next;
                break;
            } else {
                // 不相等的情况,正常遍历
                cur = cur.next;
                prev = prev.next;
            }
        }
    }

    // 删除给定值所有的相同的节点
    public void remove(int data) {
        // 判空
        if (head == null) return;

        ListNode cur = head;
        // 定义连接节点, 用于连接和data不等的节点
        ListNode dummy = new ListNode();
        // 新的头节点
        ListNode newHead = dummy;

        while (cur != null) {
            // 不相同
            if (cur.val != data) {
                // 连接到dummy的后面, 让dummy往后走一步
                dummy.next = cur;
                dummy = dummy.next;
            }
            cur = cur.next;
        }
        // 防止尾部的相同元素未删掉
        dummy.next = null;
        // head指向新链表
        head = newHead.next;
    }

    // 查找给定的key是否存在
    public boolean contains(int key) {
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == key) return true;
            cur = cur.next;
        }
        return false;
    }

    // 获取链表的长度
    public int size() {
        int count = 0;
        ListNode cur = head;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return head == null;
    }

    // 打印
    public void display() {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    // 清空链表
    public void clear() {
        ListNode cur = head;

        // 把节点置空
        while (cur != null) {
            // 获取cur的下一个节点
            ListNode curNext = cur.next;
            cur = null;
            cur = curNext;
        }
        // 头节点置空
        head = null;
    }
}