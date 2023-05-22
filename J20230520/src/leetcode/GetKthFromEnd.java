package leetcode;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。
 * 这个链表的倒数第 3 个节点是值为 4 的节点。
 */
public class GetKthFromEnd {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    /**
     * 思路分析：使用快慢指针，快指针先指向k个结点，最后快慢指针一起往后走，即慢指针可走到倒数第k个结点
     * 时间复杂度：O(n); 空间复杂度：O(1)
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        //让fast先走k步
        for (int i = 0; i < k; i++) {
            //预防k值比链表的长度还大的情况
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        //让fast和slow均往下走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}