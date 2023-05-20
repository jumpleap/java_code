package linklist;


public class SingleLinkedList {

    //结点类
    static class ListNode {
        public int data;//值域
        public ListNode next;//下一个结点的地址

        public ListNode(int data) {
            this.data = data;
        }
    }

    public ListNode head;//头节点

    //初始化链表
    public void creatList() {
        ListNode listNode1 = new ListNode(12);
        ListNode listNode2 = new ListNode(13);
        ListNode listNode3 = new ListNode(24);
        ListNode listNode4 = new ListNode(18);
        ListNode listNode5 = new ListNode(45);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        //让头结点指向第一个结点
        this.head = listNode1;
    }


    //打印出链表中的信息
    public void display() {
        ListNode cur = head;

        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = head;
        //判断链表是不是空链表
        if (cur == null) {
            head = node;
            return;
        }

        //判断下一个是不是空
        while (cur.next != null) {
            cur = cur.next;
        }

        //直接添加到后面
        cur.next = node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) throws IndexOfBoundsException {
        if (index < 0 || index > this.size()) {
            throw new IndexOfBoundsException("下标不合法！");
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

        ListNode node = new ListNode(data);
        ListNode cur = head;

        //找到插入位置的前一个位置
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        //插入
        node.next = cur.next;
        cur.next = node;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = head;

        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (head.data == key) {
            head = head.next;
            return;
        }

        //找到key的前一个结点
        ListNode cur = findPrev(key);
        if (cur == null) {
            System.out.println("链表中没有该数据~");
            return;
        }

        //删除指定的结点
        ListNode delNode = cur.next;
        cur.next = delNode.next;
    }

    //查找key对应的结点
    private ListNode findPrev(int key) {
        ListNode cur = head;

        while (cur.next != null) {
            if (cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = head;
        //第一个结点的删除
        if (cur.data == key) {
            remove(key);
            cur = cur.next;
        }

        while (cur != null) {
            //查找删除值的前一个结点
            ListNode update = findPrev(key);
            //如果链表中已经没有值和key相等的情况下
            if (update == null) {
                //说明删除完了或没有要删除的元素了
                break;
            }

            //获取要删除结点
            ListNode delNode = update.next;

            //删除当前的key结点
            update.next = delNode.next;
            cur = cur.next;//更新cur结点
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

    //清空链表
    public void clear() {
        //清空链表
        while (head != null) {
            ListNode tmp = head;
            tmp = null;
            head = head.next;
        }
    }
}