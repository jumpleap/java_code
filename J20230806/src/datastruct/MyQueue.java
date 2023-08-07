package datastruct;

/**
 * 模拟实现队列 -> 双向链表实现
 */
public class MyQueue {
    static class ListNode {
        private int val;
        private ListNode pre;
        private ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode front;//队头
    private ListNode rear;//队尾
    //private int usedSize;//记录长度

    /**
     * 入队
     * @param val 待入队的元素
     */
    public void offer(int val) {
        ListNode node = new ListNode(val);
        if (front == null) {
            front = rear = node;
        } else {
            //头插
            node.next = front;
            front.pre = node;
            front = node;
        }
    }

    /**
     * 出队：入队使用的头插法，出队的话就需要尾删
     * @return 删掉最后的一个元素
     */
    public int poll() {
        //判空
        if (front == null) {
            return -1;
        }
        //只有一个结点的情况下
        int oldValue = rear.val;
        if (front == rear) {
            front = rear = null;
            return oldValue;
        }

        //尾部删
        rear = rear.pre;
        rear.next = null;
        return oldValue;
    }

    /**
     * 获取队头元素
     */
    public int peek() {
        //判空
        if (front == null) {
            return -1;
        }
        //返回队头元素
        return rear.val;
    }

    /**
     * 判断链表是否为空 -> 只需要判断队尾是否为空
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * 重写toString()方法
     *
     * @return
     */
    public String toString() {
        ListNode cur = front;
        StringBuilder stringBuilder = new StringBuilder();
        while (cur != null) {
            stringBuilder.append(cur.val + " ");
            cur = cur.next;
        }
        return stringBuilder.toString();
    }
}