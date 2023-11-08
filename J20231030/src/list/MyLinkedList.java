package list;


public class MyLinkedList {
    static class ListNode {
        private int val; //值域
        private ListNode prev; //前驱
        private ListNode next; //后继

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head; //头节点
    private ListNode tail; //尾结点
    private int usedSize; //链表长度

    /**
     * 头插法
     */
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        //判空
        if (head == null) {
            head = tail = node;
            usedSize++;
            return;
        }
        //头插, next和prev别搞混了
        node.next = head;
        head.prev = node;
        //更新头节点
        head = node;
        usedSize++;
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = tail = node;
            usedSize++;
            return;
        }
        //尾插
        tail.next = node;
        node.prev = tail;
        //更新尾结点
        tail = node;
        usedSize++;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        judgeIndex(index); //判断下标
        if (insertHeadOrTail(index, data)) {
            return;
        }
        ListNode cur = getIndexNode(index); //找到要插入的位置

        ListNode node = new ListNode(data);
        //插入
        cur.prev.next = node;
        node.next = cur;
        node.prev = cur.prev;
        cur.prev = node;
        usedSize++;
    }


    /**
     * 判断下标是否合理
     */
    private void judgeIndex(int index) {
        if (index < 0 || index > size()) {
            throw new IndexException("下标: " + index + "异常!");
        }
    }

    /**
     * 头插尾插判断
     */
    private boolean insertHeadOrTail(int index, int data) {
        if (index == 0) { //头插
            addFirst(data);
            return true;
        } else if (index == size()) { //尾插
            addLast(data);
            return true;
        } else { //其他位置
            return false;
        }
    }

    /**
     * 获取index处的节点
     */
    private ListNode getIndexNode(int index) {
        ListNode cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    /**
     * 查找是否包含关键字key是否在单链表当中
     */
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

    /**
     * 删除第一次出现关键字为key的节点
     */
    public void remove(int key) {
        //判断key是否在链表中
        if (!contains(key)) {
            System.out.println("该元素:" + key + "不存在!");
            return;
        }

        ListNode cur = head;

        while (cur != null) {
            if (cur.val == key) {
                break;
            }
            cur = cur.next;
        }

        //删除cur这个节点
        if (cur == head) { //头删
            head = head.next;
            head.prev = null;
        } else if (cur == tail) { //尾删
            tail = tail.prev;
            tail.next = null;
        } else { //其他位置
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
        usedSize--;
    }

    /**
     * 删除所有值为key的节点
     */
    public void removeAllKey(int key) {
        if (!contains(key)) {
            System.out.println("该元素:" + key + "不存在!");
            return;
        }

        ListNode cur = head;

        //循环删除和key相同的节点
        while (cur != null) {
            if (cur.val == key) {
                //删除cur这个节点
                if (cur == head) {
                    head = head.next;
                    head.prev = null;
                } else if (cur == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                usedSize--;
            }
            cur = cur.next;
        }
    }

    /**
     * 根据下标找到节点
     */
    public int getNode(int index) {
        //下标判断
        if (index < 0 || index >= size()) {
            throw new IndexException("下标: " + index + "异常!");
        }

        ListNode cur = head;
        //查找节点
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * 获取单链表的长度
     */
    public int size() {
        return this.usedSize;
    }

    /**
     * 打印链表
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
     * 链表清空
     */
    public void clear() {
        head = tail = null;
        /*ListNode cur = head;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.prev= null;
            cur.next = null;
            cur.val = null;

            cur = cur.next;
        }
        head = tail = null;*/
    }
}