package data_struct;


public class MySingleList {

    /**
     * 定义节点类
     */
    static class ListNode {
        private int val; //值
        private ListNode next; //下一个节点的引用

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head; //头节点

    /**
     * 头插法
     */
    public void headInsert(int value) {
        //申请节点
        ListNode node = new ListNode(value);

        //头插
        node.next = head;
        head = node;
    }

    /**
     * 尾插法
     */
    public void tailInsert(int value) {
        //申请节点
        ListNode node = new ListNode(value);

        //head为空
        if (head == null) {
            //head直接指向node
            head = node;
            return;
        }

        ListNode cur = head;
        //找最后一个节点
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = node;
    }

    /**
     * 任意位置插入
     */
    public void randomInsert(int index, int value) {
        //判断下标是否合理
        judge(index);

        //判断是否是头插或尾插
        if (isInsert(index, value)) {
            return;
        }

        //中间位置插入
        ListNode cur = head;
        //找到插入位置的前一个位置
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }

        //插入
        ListNode node = new ListNode(value);
        node.next = cur.next;
        cur.next = node;

    }

    /**
     * 判断下标是否合理
     */
    private void judge(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOFBoundException("下标: " + index + "错误!");
        }
    }

    /**
     * 判断插入位置是否是头插或尾插
     */
    private boolean isInsert(int index, int value) {
        if (index == 0) { //头插
            headInsert(value);
            return true;
        } else if (index == size()) { //尾插
            tailInsert(value);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 查找value是否在链表中存在
     */
    public boolean contains(int value) {
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == value) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除链表中第一次出现value的节点
     */
    public void remove(int value) {
        //head为空或要删除的节点是head
        if (isNullOrHead(value)) {
            return;
        }

        //获取要删除节点的前一个节点
        ListNode preNode = findFirstDeletePreNode(value);
        //判断preNode为空
        if (preNode == null) {
            System.out.println("没有这个元素对应的节点");
            return;
        }

        //删除节点
        ListNode delNode = preNode.next;
        preNode.next = delNode.next;
    }

    /**
     * 要删除的节点为空或是第一个节点
     */
    private boolean isNullOrHead(int value) {
        if (head == null) { //head为空
            return true;
        } else if (head.val == value) { //head的val和value相同
            //head后移
            head = head.next;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 查找要删除value节点
     */
    private ListNode findFirstDeletePreNode(int value) {
        ListNode cur = head;
        while (cur.next != null) {
            //找到了要删除节点的前驱
            if (cur.next.val == value) {
                return cur;
            }
            cur = cur.next;
        }
        //没找到
        return null;
    }

    /**
     * 删除所有值为value的节点
     */
    public void removeAllValue(int value) {
        //判空
        if (head == null) return;

        ListNode prev = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val == value) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        //判断第一个节点的值是否和value相等
        if (head.val == value) {
            head = head.next;
        }
    }

    /**
     * 获取单链表的长度
     */
    public int size() {
        ListNode cur = head;
        int count = 0;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    /**
     * 清空单链表
     */
    public void clear() {
        //把head置为null
        this.head = null;
    }

    /**
     * 打印数组中的元素
     */
    public void display() {
        ListNode cur = head;

        while (cur != null) {
            System.out.print(cur.val + " ");
            //指向下一个值
            cur = cur.next;
        }
        System.out.println();
    }
}