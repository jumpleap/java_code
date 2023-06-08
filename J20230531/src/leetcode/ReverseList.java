package leetcode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        //判断头节点是否非空
        if (head == null) {
            return null;
        }

        ListNode cur = head.next;
        head.next = null;//把head的下一个值置为空，防止形成闭环
        while (cur != null) {
            //获取cur的下一个值
            ListNode curNext = cur.next;
            //进行头插
            cur.next = head;
            head = cur;
            //获取cur的下一个值
            cur = curNext;
        }
        return head;
    }
}