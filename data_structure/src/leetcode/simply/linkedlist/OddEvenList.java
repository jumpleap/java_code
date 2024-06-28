package leetcode.simply.linkedlist;

import leetcode.util.ListNode;

// 奇偶链表
public class OddEvenList {
    /*
        给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
        第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
        请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
        你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
        https://leetcode.cn/problems/odd-even-linked-list/description/
     */

    /**
     * 模拟，p指向奇节点，q指向偶节点；判断q的当前节点是否为空和下一个节点是否为空
     *      让p的next指向q的next, 让p跳到指向q的next的地方，然后让q的next指向p的next，q跳到该位置，直到循环结束
     *      循环结束，让p.next指向空，防止偶数个节点的情况，然后连接p,q链表，最后返回p的头节点即可
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        // 判空
        if (head == null) return head;

        // p代表指向的是奇节点
        ListNode p = head;
        ListNode pHead = p;
        // q代表指向偶节点
        ListNode q = head.next;
        ListNode qHead = q;

        // 当偶节点为空，或偶节点的下一个节点为空跳出循环
        while (q != null && q.next != null) {
            // p的下一个指向q的下一个
            p.next = q.next;
            // p跳到指向的下一个
            p = p.next;
            // q跳到p的下一个
            q.next = p.next;
            // q跳到q指向的下一个
            q = q.next;
        }
        // 防止偶数个节点情况，p后面还有节点
        p.next = null;
        // 把q连接到p的后面
        p.next = qHead;
        // 返回连接后的节点
        return pHead;
    }
}
