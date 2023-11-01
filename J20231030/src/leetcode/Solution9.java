package leetcode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution9 {
    /**
     * 思路分析: 快慢指针
     * 让快指针每次走两步, 慢指针每次走一步; 相遇后跳出循环, 然后让快指针回溯到head节点的位置, 快慢指针一起走, 相遇点即为入环点
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        //判空
        if (head == null) return head;

        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            //相遇后跳出循环
            if (fast == slow) break;
        }

        //无环判断
        if (fast == null || fast.next == null) return null;

        //fast指针重新指向head
        fast = head;
        //快慢指针一起走, 相遇点即为入环点
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}