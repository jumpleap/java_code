package analog_queue;

public class MyQueue {
    static class ListNode {
        private int val;
        private ListNode prev;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode front;//队头
    private ListNode rear;//队尾
    private int usedSize;//有效长度

    //操作方法

    /**
     * 入队
     */
    public boolean offer(int val) {
        ListNode node = new ListNode(val);
        if(front == null) {
            front = node;
        } else {
            //队尾入
            rear.next = node;
            node.prev = rear;
        }
        rear = node;
        this.usedSize++;
        return true;
    }

    /**
     * 出队
     */
    public int pop() {
        if(isEmpty()) {
            throw new EmptyQueueException("空队！");
        }
        int oldValue = front.val;
        front = front.next;
        front.prev = null;
        this.usedSize--;
        return oldValue;
    }

    /**
     * 队头元素
     */
    public int peek() {
        if(isEmpty()) {
            throw new EmptyQueueException("空队！");
        }
        return front.val;
    }

    /**
     * 队列是否为空
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * 打印队列
     */
    public void display() {
        ListNode cur = front;
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}