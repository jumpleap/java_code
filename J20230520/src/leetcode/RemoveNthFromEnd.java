package leetcode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = new ListNode();
        cur.next = head;
        ListNode fast = head;
        ListNode slow = cur;

        //让fast先移动n个结点
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //让fast和slow同时移动，fast移动结束，slow移动到要删除的前一个结点
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //删除结点
        slow.next = slow.next.next;
        return cur.next;
    }
}
