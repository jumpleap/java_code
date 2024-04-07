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

    /**
     * 头插法
     */
    public void addFirst(int val) {
        ListNode node = new ListNode(val);
        // 判空
        if (head == null) {
            head = tail = node;
            return;
        }

        // 头插
        node.next = head;
        head.prev = node;
        // 重置head
        head = node;
    }

    /**
     * 尾插法
     */
    public void addLast(int val) {
        ListNode node = new ListNode(val);
        // 判空
        if (head == null) {
            head = tail = node;
            return;
        }

        // 尾插
        tail.next = node;
        node.prev = tail;
        // 重置tail
        tail = node;
    }

    /**
     * 任意位置插入,第一个数据节点为0号下标
     */
    public void addIndex(int index, int val) {
        // 下标判断
        if (index < 0 || index > size()) {
            throw new IndexException("下标异常: " + index);
        }

        // 头插
        if (index == 0) {
            addFirst(val);
            return;
        }
        // 尾插
        if (index == size()) {
            addLast(val);
            return;
        }

        ListNode node = new ListNode(val);
        // 遍历节点
        ListNode cur = head;
        // 遍历到待插入的位置
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        // 进行插入
        // 把cur后面的节点连接到node的后面
        node.next = cur.next;
        // 把cur后一个节点的前驱指向node
        cur.next.prev = node;
        // cur的next指向node
        cur.next = node;
        // node的prev指向cur
        node.prev = cur;
    }

    /**
     * 查找是否包含关键字key是否在单链表当中
     */
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            // 找到了
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        // 没找到
        return false;
    }

    /**
     * 删除第一次出现关键字为key的节点
     */
    public void remove(int key) {
        // 判空
        if (head == null) return;

        ListNode cur = head;
        while (cur != null) {
            // 找到待删除的节点
            if (cur.val == key) {
                // 头节点的情况
                if (cur == head) {
                    head = head.next;
                    // 只有一个节点的情况
                    if (head == null) {
                        // 尾结点置空
                        tail = null;
                        return;
                    } else {
                        // 多个节点的情况
                        head.prev = null;
                    }
                } else if (cur == tail) {
                    // 尾结点的情况
                    // tail指向前一个节点
                    tail = tail.prev;
                    // tail的后一个节点的指向置空
                    tail.next = null;
                } else {
                    // 中间情况
                    // 把要删除节点的前一个节点的后继更改
                    cur.prev.next = cur.next;
                    // 把要删除节点的后一个节点的前驱更改
                    cur.next.prev = cur.prev;
                }
                break;
            }
            cur = cur.next;
        }
    }

    /**
     * 删除所有值为key的节点
     */
    public void removeAllKey(int key) {
        // 判空
        if (head == null) return;

        ListNode cur = head;
        while (cur != null) {
            // 找到待删除的节点
            if (cur.val == key) {
                // 头节点的情况
                if (cur == head) {
                    head = head.next;
                    // 只有一个节点的情况
                    if (head == null) {
                        // 尾结点置空
                        tail = null;
                        return;
                    } else {
                        // 多个节点的情况
                        head.prev = null;
                    }
                } else if (cur == tail) {
                    // 尾结点的情况
                    // tail指向前一个节点
                    tail = tail.prev;
                    // tail的后一个节点的指向置空
                    tail.next = null;
                } else {
                    // 多个节点的情况
                    // 把要删除节点的前一个节点的后继更改
                    cur.prev.next = cur.next;
                    // 把要删除节点的后一个节点的前驱更改
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;
        }
    }

    /**
     * 获取双向链表的长度
     */
    public int size() {
        ListNode cur = head;
        int size = 0;

        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    /**
     * 打印
     */
    public void display() {
        ListNode cur = head;

        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 清空双向链表
     */
    public void clear() {
        ListNode cur = head;

        while (cur != null) {
            ListNode curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
        head = tail = null;
    }
}
