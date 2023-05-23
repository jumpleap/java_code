package leetcode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //1、分别求2个链表的长度
        int lenA = 0;
        int lenB = 0;

        ListNode pL = headA;//假设pL 所指向的链表 是最长的链表
        ListNode pS = headB;//假设pS 所指向的链表 是最短的链表

        lenA = getLengthNode(pL);
        lenB = getLengthNode(pS);


        //分别求得了 2个链表的长度
        int len = lenA - lenB;
        //修正指向 和 len的差值
        if (len < 0) {
            pL = headB;
            pS = headA;
            len = lenB - lenA;
        }
        //我们都能保证PL一定指向最长的链表  PS 一定指向最短的链表   len 一定是一个正数

        //2、让最长的链表 先走差值步
        while (len != 0) {
            pL = pL.next;
            len--;
        }

        //3、就是相遇的点
        while (pL != null && pS != null) {
            if (pL == pS) {
                return pL;
            }
            pL = pL.next;
            pS = pS.next;
        }
        return null;
    }

    private int getLengthNode(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}
