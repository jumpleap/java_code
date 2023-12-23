package data_structure.linkedlist.singlelist;


// 单链表的模拟实现
public class MySingleList {
    // 节点类
    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }
    }


    // 定义头节点
    private ListNode head;

    // 头插法
    public void insertHead(int data) {
        // 申请节点
        ListNode node = new ListNode(data);
        // 进行头插
        node.next = head;
        head = node;
    }

    // 尾插法
    public void insertTail(int data) {
        // 申请节点
        ListNode node = new ListNode(data);
        // 判空
        if (head == null) {
            head = node;
            return;
        }

        ListNode cur = head;
        // 找到最后一个节点的位置
        while (cur.next != null) {
            cur = cur.next;
        }

        // 把node连接到最后一个节点的位置
        cur.next = node;
    }

    // 在指定位置插入
    public void insertRandom(int index, int data) {
        // 申请节点
        ListNode node = new ListNode(data);
        // 判空
        if (head == null) {
            head = node;
            return;
        }
        // 判断index是否合法
        checkIndex(index, size());

        // 头插
        if (index == 0) {
            insertHead(data);
            return;
        }
        // 尾插
        if (index == size()) {
            insertTail(data);
            return;
        }

        ListNode cur = head;
        // 找到index的前一个位置
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }

        // 在index处插入
        node.next = cur.next;
        cur.next = node;
    }


    // 判断index是否合法
    private void checkIndex(int index, int size) {
        if (index < 0 || index > size) {
            throw new IndexOfException("下标错误: " + index);
        }
    }

    // 删除第一次和data相同的节点
    public void remove(int data) {
        // 判空
        if (head == null) {
            System.out.println("链表中无此元素!");
            return;
        }

        // 头节点判断
        if (head.val == data) {
            head = head.next;
            return;
        }

        // 找到要删除的前一个节点
        ListNode cur = searchPrev(data);
        if (cur == null) {
            System.out.println("你要删除的节点不存在!");
            return;
        }
        // 删掉要删除的节点
        cur.next = cur.next.next;
    }

    // 找要删除节点的前一个节点
    public ListNode searchPrev(int data) {
        ListNode cur = head;
        while (cur.next != null) {
            // 相等即返回
            if (cur.next.val == data) {
                return cur;
            }
            cur = cur.next;
        }
        // 没找到
        return null;
    }

    // 删除链表中所有和data相同的节点值
    public void removeAllKey(int data) {
        // 判空
        if (head == null) {
            return;
        }

        ListNode cur = head.next;
        ListNode prev = head;
        while (cur != null) {
            // 相等则让prev.next指向cur的下一个节点
            if (cur.val == data) {
                prev.next = cur.next;
            } else {
                // 不相等则让prev指向cur节点
                prev = cur;
            }
            cur = cur.next;
        }

        // 判断头节点
        if (head.val == data) {
            head = head.next;
        }
    }

    // 判断链表中是否包含data值
    public boolean contains(int data) {
        ListNode cur = head;
        while (cur != null) {
            // 找到了
            if (cur.val == data) {
                return true;
            }
            cur = cur.next;
        }
        // 没找到
        return false;
    }

    // 获取链表的长度
    public int size() {
        ListNode cur = head;
        int count = 0;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    // 打印
    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    // 清空链表
    public void clear() {
        this.head = null;
        // 若数据是Object类型, 需要循环把所有数据置空
    }
}