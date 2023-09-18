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
public class Solution3 {
    /**
     * 思路分析: 快慢指针. 快指针每次走两步, 慢指针每次走一步.
     * 1) 定义快慢指针, 快指针每次走两步, 慢指针每次走一步, 当fast为空或fast.next为空跳出循环
     * 2) 判断跳出循环的情况:
     *      a. fast为空或fast.next为空跳出循环
     *      b. 没有环的情况
     * 3) 没有环的情况跳出循环, 判断fast为空或fast.next为空,为空直接返回null
     * 4) 有环的情况跳出循环, 让fast重新指向head, 快慢指针一起走, 相遇即为入环点
     * 注: 有环的情况下, 当fast=slow后跳出了循环, 即两者已经相遇
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param head 头节点
     * @return 返回入环点, 没有返回null
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            //fast走两步,slow走一步
            fast = fast.next.next;
            slow = slow.next;

            //相遇了跳出循环
            if (fast == slow) {
                break;
            }
        }

        //判断情况:是遇到空跳出的循环还是遇到环
        if (fast == null || fast.next == null) return null;

        //让快指针重新指向头节点, 快慢指针一起走
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}