package leetcode;

/**
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {
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

    /**
     * 法一：计数取中间值
     * 时间复杂度：O(n); 空间复杂度：O(1)
     */
    public ListNode middleNode1(ListNode head) {
        //判断链表非空
        if (head == null) {
            return null;
        }

        int count = 0;
        ListNode cur = head;
        //计算链表中的元素个数
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        count /= 2;//取中间结点
        cur = head;//重置

        //找到中间结点
        while (count != 0) {
            cur = cur.next;
            count--;
        }
        return cur;
    }

    /**
     * 法二：快慢指针（快指针的速度为慢指针的两倍）
     * 时间复杂度：O(n); 空间复杂度：O(1)
     */
    public ListNode middleNode(ListNode head) {
        //判断链表非空
        if (head == null) {
            return null;
        }

        ListNode fast = head;//快指针
        ListNode slow = head;//慢指针

        while (fast != null && fast.next != null) {
            //快指针走两步，慢指针走一步
            fast = fast.next.next;
            slow = slow.next;
        }
        //中间结点
        return slow;
    }
}