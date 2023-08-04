package leetcode;

/*
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。

图示两个链表在节点 c1 开始相交：
题目数据 保证 整个链式结构中不存在环。

注意，函数返回结果后，链表必须 保持其原始结构 。
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * 思路分析：求链表的长度，让长度长的链表走两者的差值步，最后两个一起走，若是有相交节点，则返回相交节点，反之返回null
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param headA 链表A
     * @param headB 链表B
     * @return 返回相交的节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;//l1指向headA链表
        ListNode l2 = headB;//l2指向headB链表

        //求headA和headB链表的长度
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        //长度差
        int gap = lenA - lenB;

        //若headA的长度小于headB，那么更换指向
        if (lenA < lenB) {
            l1 = headB;//l1指向长度长的那个
            l2 = headA;//l2指向长度短的那个
            gap = -gap;//gap取相反数
        }

        //让长度长的l1先走两者的差值步
        for (int i = 0; i < gap; i++) {
            l1 = l1.next;
        }

        //让l1和l2同时一起走
        while (l1 != null && l2 != null) {
            //若l1和l2相同
            if (l1 == l2) {
                //直接返回相交的节点
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        //不存在相交的节点
        return null;
    }

    //求链表长度
    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}