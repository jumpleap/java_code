package practice;

import java.util.Stack;

/**
 * 逆序打印链表中的内容
 */
public class Test {
    class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;

    public static void main(String[] args) {
        Test test = new Test();
        test.init();
        ListNode cur = test.head;
        test.reverseList(cur);
        System.out.println();

        test.reverseList();
    }

    /**
     * 使用递归逆序打印链表中数值
     * @param head
     */
    private void reverseList(ListNode head) {
        if (head != null) {
            reverseList(head.next);
            System.out.print(head.val + " ");
        }
    }

    /**
     * 使用栈逆序打印链表
     */
    private void reverseList() {
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();

        while (cur != null) {
            //入栈
            stack.push(cur);
            cur = cur.next;
        }

        while (!stack.empty()) {
            int ret = stack.pop().val;
            System.out.print(ret + " ");
        }
        System.out.println();
    }

    /**
     * 初始化链表
     */
    private void init() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        head = listNode1;
    }
}

