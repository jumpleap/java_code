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
class Solution1 {
    /**
     * 思路分析: 双指针: 定义一个pre指针和一个cur指针
     * 1) pre指针用于遍历链表, 查找链表和val相同的节点
     * 2) pre指针用于删除cur查找的和val相同的节点
     * 3) cur指向和val相同的节点时, 让pre.的下一个指向cur的下一个(不是pre改变了, 是它的下一个指向改变),cur后移;
     *    cur指向和val不相等的节点时, 直接让pre指向cur, cur后移
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param head 给定头节点
     * @param val val值
     * @return 新链表
     */
    public ListNode removeElements(ListNode head, int val) {
        //判空
        if (head == null) return null;

        //用于遍历链表找和val相同的节点
        ListNode cur = head.next;
        //用于删除cur中找到和val相同节点
        ListNode pre = head;

        //遍历链表
        while (cur != null) {
            //值相等
            if (cur.val == val) {
                //让pre的下一个指向cur的下一个
                pre.next = cur.next;
            } else {
                //不相等则让pre指到cur的位置
                pre = cur;
            }
            cur = cur.next;
        }

        //判断头节点
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
}