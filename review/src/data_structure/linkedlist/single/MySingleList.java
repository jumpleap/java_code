package data_structure.linkedlist.single;

/**
 * @Author 林沐雨
 * @Date 2025/4/28
 * @Description 模拟实现单链表
 */
public class MySingleList {
    static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    // 头节点
    private Node head;

    // 头插法
    public void headInsert(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    // 尾插法
    public void tailInsert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }

        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    // 任意位置插入
    public void insert(int index, int val) {
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

        Node node = new Node(val);
        Node cur = head;

        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
    }

    // 查找val是否在链表中
    public boolean contains(int val) {
        Node cur = head;
        while (cur != null) {
            if (cur.val == val) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 删除第一次与val相同的值
    public void remove(int val) {
        int index = findIndex(val);
        if (index == -1) {
            System.out.println("链表中不存在:" + val +"，无法删除！");
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }

        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }

    private int findIndex(int val) {
        Node cur = head;
        int idx = 0;
        while (cur != null) {
            if (cur.val == val) {
                return idx;
            }
            idx++;
            cur = cur.next;
        }
        return -1;
    }

    // 删除所有与val相同的值
    public void removeOfVal(int val) {
        if (head == null) return;
        Node cur = head.next;
        Node prev = head;

        while (cur != null) {
            if (cur.val == val) {
                // 连续判断多个值是否和val相等
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }

        // 还剩头节点没有判断
        if (head.val == val) {
            head = head.next;
        }
    }

    // 获取链表的长度
    public int size() {
        Node cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    // 打印
    public void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    // 清空链表
    public void clear() {
        head = null;
    }
}
