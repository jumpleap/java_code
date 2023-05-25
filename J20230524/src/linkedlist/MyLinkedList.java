package linkedlist;

@SuppressWarnings({"all"})

/**
 * 模拟实现不带头的双向链表
 */
public class MyLinkedList {
    //内部类
    static class ListNode {
        private int val;
        private ListNode prev;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //头节点和尾结点
    private ListNode head;
    private ListNode tail;

    //各种方法

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);

        //判断头和尾结点是不是null
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        //插入
        node.next = head;
        head.prev = node;
        head = node;
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        //判断
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        //插入位置
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        checkIndex(index);

        //头插和尾插
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == this.size()) {
            addLast(data);
            return;
        }

        ListNode node = new ListNode(data);
        //查找要插入的位置
        ListNode cur = searchIndex(index);

        //进行插入
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }

    //查找插入位置
    private ListNode searchIndex(int index) {
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //检查下标是否合法
    private void checkIndex(int index) {
        if (index < 0 || index > this.size()) {
            throw new IndexOfBoundsException("下标不合法：" + index);
        }
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            //找到了
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //头删
    public void delHead() {
        if (head == null) {
            return;
        }
        //指向下一个，前驱置为null
        head = head.next;
        head.prev = null;
    }

    //尾删
    public void delTail() {
        if (tail == null) {
            return;
        }
        //指向前一个并后继置为null
        tail = tail.prev;
        tail.next = null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        //判断key是不是在链表中
        if (!contains(key)) {
            System.out.println("没有该元素~");
            return;
        }
        //得到删除的元素点
        ListNode delNode = getNode(key);

        //删掉头或尾结点
        if (delNode == head) {
            delHead();
            return;
        }
        if (tail == delNode) {
            delTail();
            return;
        }

        //中间其他结点
        delNode.prev.next = delNode.next;
        delNode.next.prev = delNode.prev;
    }

    //查找key对应链表的结点
    private ListNode getNode(int key) {
        ListNode cur = head;
        while (cur != null) {
            //找到了
            if (cur.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = head;
        ListNode del = null;

        while (cur != null) {
            if (cur.val == key) {
                remove(key);
            }
            cur = cur.next;
        }
    }

    //得到单链表的长度
    public int size() {
        ListNode cur = head;
        int count = 0;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //打印链表中的指
    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();//换行
    }

    //情况链表
    public void clear() {
        //this.head = null;
        //this.tail = null;
        ListNode cur = head;
        while(cur != tail) {
            ListNode curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
        head = null;
        tail = null;
    }
}