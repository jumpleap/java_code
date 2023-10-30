package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution2 {
    /**
     * 思路分析: 快慢指针
     * 当快指针的速度是慢指针的2倍时, 快指针走完链表后, 慢指针刚好到链表的中间位置
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;

        //快指针遍历数组
        while (fast != null && fast.next != null) {
            //fast每次走两步
            fast = fast.next.next;
            //slow每次走一步
            slow = slow.next;
        }
        //返回中间节点
        return slow;
    }
}