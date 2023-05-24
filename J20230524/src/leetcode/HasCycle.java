package leetcode;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 */
public class HasCycle {
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

    /**
     * 思路分析：快慢指针：快指针每次走两步，慢指针每次走一步
     * 若是无环，快指针则为null，跳出循环；若有环，两者必定相遇
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        //fast每次走两步，slow每次走一步，两者若是有环必定会相遇
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //有环则说明两者相等
            if (fast == slow) {
                return true;
            }
        }
        //无环
        return false;
    }
}