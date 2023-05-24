package leetcode;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 */
public class DetectCycle {
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
     * 思路分析：使用快慢指针判断链表是否有环，若无环，直接返回false；
     * 有环，则快慢指针到达相遇点后，让其中一个指针重置到head，然后每次两者各走一步，相等的点即为入口点
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //fast和slow相同跳出循环
            if (fast == slow) {
                break;
            }
        }
        //如果fast和fast.next为空，则说明这个链表无环
        if (fast == null || fast.next == null) {
            return null;
        }

        //有环，让fast重置，两者路程相同
        fast = head;
        //两者相同的点即为入口点
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        //返回入口点
        return fast;
    }
}
