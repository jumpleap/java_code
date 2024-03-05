package data_structure.queue;

// 队列的模拟实现(链队)
public class MyQueue {
    // 创建节点类
    static class ListNode {
        private int val;
        private ListNode prev;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // 队头
    private ListNode head;
    // 队尾
    private ListNode tail;
    // 有效元素个数
    private int usedSize;

    /**
     * 入队
     */
    public void offer(int val) {
        // 创建新节点
        ListNode node = new ListNode(val);
        // 判空
        if (head == null) {
            head = tail = node;
        } else {
            // 头插法
            node.next = head;
            head.prev = node;
            head = node;
        }
        usedSize++;
    }

    /**
     * 出队
     */
    public int poll() {
        // 判断队列是否为空
        if (head == null) {
            return -1;
        }
        // 获取要出队的节点值
        int oldVal = tail.val;
        // 只有一个节点的情况
        if (head == tail) {
            head = tail = null;
            usedSize--;
            return oldVal;
        }
        // 多个节点的情况
        tail = tail.prev;
        // 把要出队的节点置空
        tail.next = null;
        // 有效长度-1
        usedSize--;
        return oldVal;
    }

    /**
     * 获取队头元素
     */
    public int peek() {
        // 判断队列是否为空
        if (head == null) {
            return -1;
        }
        return tail.val;
    }

    /**
     * 获取队列长度
     */
    public int size() {
        return this.usedSize;
    }


    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    /**
     * 打印
     */
    public String toString() {
        ListNode cur = head;
        StringBuilder s = new StringBuilder();

        while (cur != null) {
            s.append(cur.val).append(" ");
            cur = cur.next;
        }
        return s.toString();
    }
}