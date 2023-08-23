package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution7 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        int lenA = getLen(l1);//headA的长度
        int lenB = getLen(l2);//headB的长度

        //获取两个链表的差值
        int gap = lenA - lenB;
        //若差值小于0，则l1和l2的指向改变
        if (gap < 0) {
            l1 = headB;
            l2 = headA;
            gap = -gap;
        }

        //先让l1走多出来的gap步
        for (int i = 0; i < gap; i++) {
            l1 = l1.next;
        }

        //两个一起走，一直走到相同的地方
        while (l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        //返回相同的节点位置
        return l1;
    }

    //求链表的长度
    private int getLen(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}