package data_structure.linkedlist.linked;

/**
 * @Author 林沐雨
 * @Date 2025/4/29
 * @Description 模拟实现双向链表
 */
public class MyLinkedList {
    // 节点类
    static class ListNode {
        private int val;
        private ListNode prev;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // 头节点
    private ListNode head;
    // 尾结点
    private ListNode tail;

    // 头插法
    public void headInsert(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = tail = node;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
    }


    // 尾插法
    public void tailInsert(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    // 任意位置插入，从0开始
    public void insert(int index, int val) {
        if (head == null) return;

        if (index < 0 || index > size()) {
            System.out.println("下标异常：" + index);
            return;
        }
        if (index == 0) {
            headInsert(val);
            return;
        }
        if (index == size()) {
            tailInsert(val);
            return;
        }

        ListNode node = new ListNode(val);
        ListNode cur = head;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next.prev = node;
        node.prev = cur.prev;
        cur.prev.next = node;
    }

    // 判断val是否在链表中出现
    public boolean contains(int val) {
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 删除第一次出现的val
    public void remove(int val) {
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                if (cur == head) {
                    head = head.next;
                    head.prev = null;
                    return;
                } else if(cur == tail){
                    tail = tail.prev;
                    tail.next = null;
                    return;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                    return;
                }
            }
            cur = cur.next;
        }
    }

    // 删除所有值为val的节点
    public void removeAllVal(int val) {
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                if (cur == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (cur == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;
        }
    }

    // 长度
    public int size() {
        ListNode cur = head;
        int count = 0;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    // 打印
    public void display() {
        ListNode cur = head;

        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    // 清空
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
