package leetcode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;

        //获取两个链表的长度
        int len1 = getLen(headA);
        int len2 = getLen(headB);
        int gap = len1 - len2;//长度的差值

        //让l1永远指向最长的那个链表
        if (len1 < len2) {
            l1 = headB;
            l2 = headA;
            gap = -gap;//gap取相反数
        }

        //让l1先走gap步
        for (int i = 0; i < gap; i++) {
            l1 = l1.next;
        }

        //两个一起走
        while (l1 != l2 && l1 != null && l2 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        //返回相交的结点
        return l1;
    }

    //计算链表的长度
    private int getLen(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}