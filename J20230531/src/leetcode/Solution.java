package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //判断head是不是非空
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        //遍历head中的结点
        while (cur.next != null) {
            //判断下一个结点的值是不是和val相等
            if (cur.next.val == val) {
                //下一个结点指向下下个结点
                cur.next = cur.next.next;
            } else {
                //不相等的话，让cur指向下一个结点
                cur = cur.next;
            }
        }

        //判断第一个结点
        if (head.val == val) {
            head = head.next;
        }
        //返回最后的结果
        return head;
    }
}