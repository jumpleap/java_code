package leetcode;

import task.ListNode;

/*
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class MergeTwoLists {
    /**
     * 思路分析：遍历两个循环，判断值的大小，小的则连接到新链表的后面
     * 时间复杂度：O(n + m)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (l1 != null || l2 != null) {
            if (l1 == null) { //l1链表为空
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            } else if (l2 == null) { //l2链表为空
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val) { //l1的值比l2的大
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            }
        }
        return dummy.next;
    }
}
