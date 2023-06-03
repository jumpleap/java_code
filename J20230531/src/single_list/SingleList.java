package single_list;

public class SingleList {
    static class ListNode {
        private int val;//值域
        private ListNode next;//指向下一个结点

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;//头节点

    /**
     * 方法
     */

    /**
     * 头插法
     */
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        //进行头插
        node.next = this.head;
        this.head = node;
    }

    /**
     * 尾插法
     */
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        //判断头节点非空
        if (this.head == null) {
            this.head = node;
            return;
        }
        //找到最后一个位置
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        //尾插
        cur.next = node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        //判断下标异常
        if (index < 0 || index > this.size()) {
            throw new IndexOfSArraysException("下标错误！");
        }

        //头插
        if (index == 0) {
            addFirst(data);
            return;
        }
        //尾插
        if (index == this.size()) {
            addLast(data);
            return;
        }

        //其他位置插入
        ListNode cur = insertPos(index);
        ListNode node = new ListNode(data);
        node.next = cur.next;
        cur.next = node;
    }

    /**
     * 找到要插入位置
     */
    private ListNode insertPos(int index) {
        ListNode cur = this.head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 查找关键字key是否在单链表当中
     */
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
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
        //判断head非空
        if (head == null) {
            return;
        }
        //若头节点相同
        if (head.val == key) {
            head = head.next;
            return;
        }

        ListNode ret = searchPrev(key);
        if (ret == null) {
            System.out.println("没有你要删除的值");
            return;
        }
        //删除结点
        ListNode node = ret.next;
        ret.next = node.next;

    }

    /**
     * 查找要删除结点的前驱
     */
    private ListNode searchPrev(int key) {
        ListNode cur = this.head;
        while (cur.next != null) {
            //相等则跳出
            if (cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;//没找到
    }

    /**
     * 删除所有值为key的节点：法一
     */
    public void removeAllKey(int key) {
        //判断头节点非空
        if (this.head == null) {
            return;
        }

        ListNode cur = this.head;
        //判断cur.next非空
        while (cur.next != null) {
            //若值相等，直接指向下下个结点处
            if (cur.next.val == key) {
                cur.next = cur.next.next;
            } else {
                //不相等的值继续迭代
                cur = cur.next;
            }
        }
        //判断头节点的值
        if (head.val == key) {
            head = head.next;
        }
    }

    /**
     * 删除所有值为key的节点：法二
     */
    public void removeAllKey1(int key) {
        if (head == null) {
            return;
        }

        ListNode cur = head.next;
        ListNode prev = head;
        //删除与key相同的结点
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        //判断头节点的值
        if (head.val == key) {
            head = head.next;
        }
    }

    /**
     * 单链表的长度
     */
    public int size() {
        int count = 0;
        ListNode cur = this.head;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    /**
     * 打印链表中的内容
     */
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();//换行
    }

    /**
     * 清空链表中的内容
     */
    public void clear() {
        this.head = null;
    }
}