package leetcode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
 * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 */
public class Partition {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    /**
     * 思路分析：把小于x的链表结点放在list1中，把大于的放在list2链表中，最后把两个链表连接，返回起始地址即可
     * 时间复杂度：O(n); 空间复杂度：O(1)
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();
        ListNode listEnd = list2;
        ListNode ret = list1;
        ListNode cur = head;

        while (cur != null) {
            //结点值小于x，则把该节点连接在list1链表后
            if (cur.val < x) {
                //连接结点到list1后，并使list1向后指
                list1.next = cur;
                list1 = list1.next;
            } else {
                //连接到list2后，并使list2向后指
                list2.next = cur;
                list2 = list2.next;
            }
            //cur进行遍历
            cur = cur.next;
        }
        //需把list2的最后一个结点
        list2.next = null;
        //把list1和list2连接到一切
        list1.next = listEnd.next;
        //返回起始地址
        return ret.next;
    }
}
