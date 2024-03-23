package data_structure.linkedlist;


// 无头双向链表模拟实现
public class MyLinkedList {
    // 节点类
    static class ListNode {
        private int val;
        private ListNode prev;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    // 头节点
    private ListNode head;
    // 尾节点
    private ListNode tail;

    //头插法
    public void addFirst(int val) {
        ListNode node = new ListNode(val);

        if (head == null) {
            head = tail = node;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
    }

    //尾插法
    public void addLast(int val) {
        ListNode node = new ListNode(val);

        if (head == null) {
            head = tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int val) {
        if (index < 0 || index > size()) {
            return;
        }

        if (index == 0) {
            addFirst(val);
            return;
        }

        if (index == size()) {
            addLast(val);
            return;
        }

        ListNode node = new ListNode(val);
        ListNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next.prev = node;
        cur.next = node;
        node.prev = cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (head == null) return;

        // 要删除的节点是头节点的情况
        if (head.val == key) {
            head = head.next;
            return;
        }

        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val == key) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                break;
            }
            cur = cur.next;
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if (head == null) return;

        ListNode cur = head;
        ListNode dummy = new ListNode();
        ListNode newHead = dummy;

        while (cur != null) {
            while (cur != null && cur.val == key) {
                cur = cur.next;
            }
            if (cur == null) break;
            dummy.next = cur;
            dummy = dummy.next;
            cur = cur.next;
        }
        head = newHead.next;
    }

    //得到单链表的长度
    public int size() {
        ListNode cur = head;
        int size = 0;

        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    public void display() {
        ListNode cur = head;

        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
        head = tail = null;
    }
}
