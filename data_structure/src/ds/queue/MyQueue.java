package ds.queue;

// 队列的实现
public class MyQueue {
    // 节点类
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

    // 申请头节点和尾节点
    private ListNode head;
    private ListNode tail;

    // 入队
    public void offer(int val) {
        // 申请节点
        ListNode node = new ListNode(val);

        // 判空
        if (head == null) {
            head = tail = node;
            return;
        }

        // 把节点放到最后
        tail.next = node;
        node.prev = tail;
        // 重置tail
        tail = node;
    }

    // 出队
    public int poll() {
        // 判空
        if (head == null) {
            throw new QueueIsEmpty("队列为空，无法出队!");
        }

        // 不为空， 出链表头的元素
        int oldVal = head.val;

        // 只有一个节点的情况
        if (head.next == null) {
            head = tail = null;
        } else {
            // 多个节点的情况
            // 指向下一个元素
            head = head.next;
            // 前一个置空
            head.prev = null;
        }
        return oldVal;
    }

    // 获取队列头元素
    public int peek() {
        // 判空
        if (head == null) {
            throw new QueueIsEmpty("队列为空，无法获取队列头元素！");
        }

        // 队列不为空
        return head.val;
    }

    // 获取队列的大小
    public int size() {
        ListNode cur = head;
        int count = 0;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return head == null;
    }

    // 重写toString方法
    @Override
    public String toString() {
        // 初始化字符串
        StringBuilder s = new StringBuilder();
        ListNode cur = head;

        // 添加左括号
        s.append("[");
        while (cur != null) {
            // 把节点值添加到字符串
            s.append(cur.val);
            // 不是最后一个节点，添加逗号
            if (cur != tail) {
                s.append(", ");
            }
            cur = cur.next;
        }
        // 添加右括号
        s.append("]");
        return s.toString();
    }
}
