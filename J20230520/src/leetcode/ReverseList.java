package leetcode;

public class ReverseList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     */
    public ListNode reverseList(ListNode head) {
        //判断是不是空
        if (head == null) {
            return null;
        }

        ListNode cur = head.next;
        //防止形成闭环
        head.next = null;

        while (cur != null) {
            //获取cur的下一个结点
            ListNode curNext = cur.next;
            //头插法
            cur.next = head;
            head = cur;
            //重置
            cur = curNext;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }
}