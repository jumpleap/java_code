package leetcode;

/*
给你一个链表的头节点 head ，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。

如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 */
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
public class Solution6 {
    /**
     * 思路分析：快慢指针 -> 快指针每次走两步，慢指针每次走一步，若有环，必会相遇，无环则不会相遇
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head 给定头节点
     * @return 是否有环：true / false
     */
    public boolean hasCycle(ListNode head) {
        //判空
        if (head == null) {
            return false;
        }
        //定义快慢指针
        ListNode slow = head;
        ListNode fast = head;

        //因为fast需要走两步，所有需要判断当前和下一个节点是否为空
        while (fast != null && fast.next != null) {
            fast = fast.next.next;//fast走两步
            slow = slow.next;//slow走一步

            //判断fast和slow 是否相等
            if (fast == slow) {
                //相等说明有环
                return true;
            }
        }
        //若是跳出循环，说明无环
        return false;
    }
}