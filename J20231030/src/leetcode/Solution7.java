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
public class Solution7 {
    /**
     * 思路分析: 模拟.
     * 获取两个两个链表的长度, 判断出谁长, 使用一个引用指向最长的那个链表, 另一个引用指向最短的那个链表;
     * 让最长的那个链表先走两个链表的差值步, 然后两个一起走, 即可得到相遇点
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //获取A,B的长度
        int lenA = size(headA);
        int lenB = size(headB);

        //找到最长的链表
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        int len = lenA - lenB;

        if (len < 0) {
            cur1 = headB;
            cur2 = headA;
            len = -len;
        }

        //让最长的链表先走差值步
        for (int i = 0; i < len; i++) {
            cur1 = cur1.next;
        }

        //两个一起走, 相遇后即为相交点
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    private int size(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}