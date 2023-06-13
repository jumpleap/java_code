package leetcode;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null 。
 */
public class GetIntersectionNode {
    /**
     * 思路分析：让长的链表先走差值步，然后两个链表一起走，找到相同的结点
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * @param headA 第一个链表
     * @param headB 第二个链表
     * @return 返回相同的结点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;

        ListNode p = headA;
        ListNode q = headB;

        //计算两个链表的长度
        lenA = getLen(headA);
        lenB = getLen(headB);

        int len = lenA - lenB;
        //改变指向
        if (len < 0) {
            p = headB;
            q = headA;
            len = -len;
        }

        //先让长的链表走差值步
        for (int i = 0; i < len; i++) {
            p = p.next;
        }

        //然后判断p和q是否相等，不相等则一直走到相等为止
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        //返回相等的结点
        return p;
    }

    //计算链表的长度
    private int getLen(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}