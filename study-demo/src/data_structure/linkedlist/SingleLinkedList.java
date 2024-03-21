package data_structure.linkedlist;

// 无头单链表实现
public class SingleLinkedList {
    // 节点类
    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    // 头节点
    private ListNode head;

    /**
     * 头插法
     */
    public void addFirst(int val) {
        ListNode node = new ListNode(val);
        // 判空
        if (isNUll(node)) return;
        // 头插
        node.next = head;
        head = node;
    }

    /**
     * 尾插法
     */
    public void addLast(int val) {
        ListNode node = new ListNode(val);
        if (isNUll(node)) return;

        // 找到最后一个节点的位置
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        // 添加到最后一个节点
        cur.next = node;
    }

    /**
     * 判断头节点是否为空
     */
    private boolean isNUll(ListNode node) {
        // 判空
        if (head == null) {
            head = node;
            return true;
        }
        return false;
    }

    /**
     * 任意位置插入
     */
    public void addIndex(int index, int val) {
        ListNode node = new ListNode(val);
        // 获取链表长度
        int size = size();
        // 判断下标是否异常
        if (index < 0 || index > size) return;

        // 头插
        if (index == 0) {
            addFirst(val);
            return;
        }
        // 尾插
        if (index == size) {
            addLast(val);
            return;
        }

        // 遍历到要插入位置的前一个节点
        ListNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        // 插入节点
        node.next = cur.next;
        cur.next = node;
    }

    /**
     * 查找是否包含关键字key是否在单链表当中
     */
    public boolean contains(int key) {
        ListNode cur = head;

        while (cur != null) {
            // 相等返回
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除第一次出现关键字为key的节点
     * 链接: https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
     */
    public void remove(int key) {
        // 判断节点存不存在
        if (!isKey(key)) return;

        ListNode cur = head;
        while (cur != null) {
            // 判断下一个节点不为空且值相等的话,则删除
            if (cur.next != null && cur.next.val == key) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        // 判断头节点
        if (head.val == key) {
            head = head.next;
        }
    }

    /**
     * 判断key是否存在
     */
    private boolean isKey(int key) {
        if (!contains(key)) {
            System.out.println("要删除的节点不存在!");
            return false;
        }
        return true;
    }

    /**
     * 删除所有值为key的节点
     */
    public void removeAllKey(int key) {
        // 判断值是否存在
        if (!isKey(key)) return;

        // 遍历节点
        ListNode cur = head;
        // 连接节点, 连接所有和key不相等的节点
        ListNode prev = new ListNode();
        // 新头节点
        ListNode newHead = prev;

        // 遍历
        while (cur != null) {
            // 判断是否和key值相等, 一直到不和key值相等退出循环
            while (cur != null && cur.val == key) {
                cur = cur.next;
            }
            // 防止都是相同的数, 导致空指针异常
            if (cur == null) break;
            // 连接这个节点
            prev.next = cur;
            // 跳到自己的下一个节点
            prev = prev.next;
            // cur也需要进行跳一步, 因为我们当前连接了不和key相等的节点
            cur = cur.next;
        }
        // 把新链表赋给head
        head = newHead.next;
    }

    /**
     * 获取单链表的长度
     */
    public int size() {
        ListNode cur = head;
        int size = 0;

        // 遍历计算长度
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    /**
     * 清空链表
     */
    public void clear() {
        ListNode cur = head;

        // 把节点都释放置空
        while (cur != null) {
            // 指向cur的下一个节点
            ListNode tmp = cur.next;
            cur = null;
            cur = tmp;
        }
    }

    /**
     * 打印
     */
    public void display() {
        ListNode cur = head;

        // 遍历打印
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}