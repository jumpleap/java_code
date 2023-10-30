package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution3 {
    /**
     * 思路分析: 快慢指针
     * 快指针先走k步后, 此时快慢指针的差距是k步, 然后快慢指针一起走, 快指针走完链表后, 慢指针走到倒数第k个位置处
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        if (head == null) return -1;

        ListNode fast = head;
        ListNode slow = head;

        //让快指针先走k步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        //快慢指针一起走
        //快指针走完链表, 慢指针刚好到倒数第k个元素的位置
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}