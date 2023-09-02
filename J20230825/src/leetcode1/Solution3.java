package leetcode1;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 */
class Solution3 {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head 给定的头节点
     * @param val  要删除的val
     * @return 返回删除后的链表
     */
    public ListNode deleteNode(ListNode head, int val) {
        //判断头节点是否为空
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            //判断cur的下一个结点的值是否相等，相等则删除该节点
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                //不相等则遍历cur链表
                cur = cur.next;
            }
        }

        //判断头节点是否为空
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
}