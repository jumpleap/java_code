package leetcode;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，
 * 则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 */
public class DetectCycle {
    /**
     * 思路分析：快慢指针，快指针每次走两步。慢指针每次走一步；当快慢指针相等时跳出循环；
     * 然后判断循环退出的情况：1.无环跳出循环  2.有环跳出循环
     * 无环跳出循环：直接判断快指针的当前值和下一个结点的值是否为空
     * 有环跳出循环：把快指针指向头结点，然后让快慢指针一起走，若相等后，这个点即是入环点
     * 时间复杂度：O(n)  空间复杂度：O(1)
     *
     * @param head 头节点
     * @return 返回入环点
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        //判断fast和fast.next是否非空
        while (fast != null && fast.next != null) {
            //fast走两步，slow走一步
            fast = fast.next.next;
            slow = slow.next;

            //相等则跳出循环
            if (fast == slow) {
                break;
            }
        }

        //判断情况一：无环跳出循环
        if (fast == null || fast.next == null) {
            return null;
        }

        //判断情况二：有环跳出循环
        fast = head;
        while (fast != slow) {
            //两个同时走，走到的位置即为入环点
            fast = fast.next;
            slow = slow.next;
        }
        //返回入环点
        return fast;
    }
}