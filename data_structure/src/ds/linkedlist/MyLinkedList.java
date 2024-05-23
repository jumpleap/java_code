package ds.linkedlist;

// 模拟实现双向链表
public class MyLinkedList {
    // 内部类
    static class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    // 头节点和尾节点
    private ListNode head;
    private ListNode tail;

    // 头插
    public void headInsert(int val) {
        // 初始化节点
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

    // 尾插
    public void tailInsert(int val) {
        // 初始化节点
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

    // 给定位置插入
    public void randomInsert(int index, int val) {
        // 判断下标是否越界
        if (index < 0 || index > size()) {
            throw new IndexOfException("下标异常: " + index);
        }

        // 判空, 上述的下标判断中也把head为空的情况考虑了
        // if (head == null) return;

        // 头插
        if (index == 0) {
            headInsert(val);
            return;
        }

        // 尾插
        if (index == size()) {
            tailInsert(val);
            return;
        }

        ListNode node = new ListNode(val);
        // 遍历到要插入的位置
        ListNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }

        // 进行插入
        node.next = cur.next;
        cur.next.prev = node;
        cur.next = node;
        node.prev = cur;

    }

    // 删除第一次出现的val值的节点
    public void removeOfVal(int val) {
        // 判空
        if (head == null) return;

        // 查找和val相同的节点, 进行删除
        ListNode cur = head.next;
        ListNode tmp = head;
        while (cur != null) {
            // 头节点为空
            if (head.val == val) {
                // 只有一个节点的情况
                if (head.next == null) {
                    head = tail = null;
                } else {
                    // 多个节点的情况下
                    head = head.next;
                    head.prev = null;
                }
                break;
            } else if (tail.val == val) { // 尾节点的情况下
                // 只有一个节点的情况, 上述已经考虑了, 此处无需考虑
                tail = tail.prev;
                tail.next = null;
                break;
            }

            // 中间情况
            if (cur.val == val) {
                // cur.prev.next = cur.next;
                // cur.next.prev = cur.prev;
                tmp.next = cur.next;
                cur.next.prev = tmp;
                break;
            }

            // 各自指向自己的下一个节点
            cur = cur.next;
            tmp = tmp.next;
        }
    }

    // 删除和val相同值的所有节点
    public void remove(int val) {
        // 判空
        if (head == null) return;

        ListNode cur = head;
        while (cur != null) {
            // 找到待删除的节点
            if (cur.val == val) {
                // 头节点的情况
                if (cur == head) {
                    // 只有一个节点的情况
                    if (head.next == null) {
                        // 尾结点置空
                        head = tail = null;
                        return;
                    } else {
                        // 多个节点的情况
                        head = head.next;
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

    // 判断链表中是否含有val
    public boolean contains(int val) {
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) return true;
            cur = cur.next;
        }
        return false;
    }

    // 获取链表长度
    public int size() {
        ListNode cur = head;
        int count = 0;

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

    // 打印链表
    public void display() {
        ListNode cur = head;

        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    // 清空链表
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
