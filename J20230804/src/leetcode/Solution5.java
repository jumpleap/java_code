package leetcode;

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
class Solution5 {
    /**
     * 思路分析：快慢指针 -> 让快指针先走n步，然后快慢指针一起走，快指针走到null的时候，慢指针走到要删除结点的前一个结点
     * 注：慢指针应该指向一个申请的带头的链表
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head 给定的头节点
     * @param n 倒数第n个结点
     * @return 返回删除后的链表
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //判空
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //定义快慢指针
        ListNode slow = dummy;
        ListNode fast = head;

        //让快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //快慢指针一起走
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //走到这个位置，慢指针指向要删除节点的前一个结点
        //删除倒数第n个结点
        slow.next = slow.next.next;
        //返回新的链表
        return dummy.next;
    }
}