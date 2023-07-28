package leetcode;

import task.ListNode;

/*
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 */
public class GetKthFromEnd {
    /**
     * 思路分析：快慢指针 -> 让快指针先走k步，然后快慢指针一起走，最后慢指针的位置就是倒数第k个的位置
     * 时间复杂度：O(n)
     * @param head 给定头节点
     * @param k    k指
     * @return 返回倒数第k个节点
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        //判空
        if (head == null) {
            return head;
        }

        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;

        //让快指针先走k步
        for (int i = 0; i < k; i++) {
            //说明k已经超过了数组长度
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        //快慢指针一起走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}