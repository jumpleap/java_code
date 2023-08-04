package leetcode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * 思路分析：快慢指针 -> 快指针每次走两步，慢指针每次走一步；
     * 若无环，跳出循环后检测快指针的当前结点或下一个节点是否为空，为空则返回null
     * 若有环，快慢指针相等后跳出循环，让快指针回到起点，然后快慢指针一起走，相遇点则为入环点
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head 给定头节点
     * @return 返回入环点
     */
    public ListNode detectCycle(ListNode head) {
        //判空
        if (head == null) {
            return head;
        }

        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;

        //让快慢指针走到相遇点
        while (fast != null && fast.next != null) {
            //快指针走两步，慢指针走一步
            fast = fast.next.next;
            slow = slow.next;

            //相等则跳出循环
            if (fast == slow) {
                break;
            }
        }
        //若无环，则也跳出了循环
        if (fast == null || fast.next == null) {
            return null;
        }

        //快指针回到起点
        fast = head;
        //快慢指针一起走
        while (fast != null && slow != null) {
            //相遇点即为入环点，跳出循环
            if (fast == slow) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        //返回入环点
        return slow;
    }
}