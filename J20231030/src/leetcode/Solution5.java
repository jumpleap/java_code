package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution5 {
    /**
     * 思路分析: 模拟
     * 1) 定义四个链表, minVal链表存储比x小的节点, maxVal链表存储比x大的节点, minHead指向minVal, maxHead指向maxVal
     * 2) 循环head链表, 把比x小的节点放入到minVal链表中, 比x大的节点放入到maxVal链表中
     * 3) 防止形成环, 把maxVal.next置为空, 因为最大的值不一定是最后一个
     * 4) 连接两个链表, 并返回新链表的头节点
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        //判空
        if (head == null) return head;

        //比x值小的链表
        ListNode minVal = new ListNode(-1);
        ListNode minHead = minVal;
        //比x值大的链表
        ListNode maxVal = new ListNode(-1);
        ListNode maxHead = maxVal;

        //遍历链表
        ListNode cur = head;
        while (cur != null) {
            //判断cur的值是大于还是小于x
            if (cur.val < x) {
                //把cur的当前节点放到minVal的后面
                minVal.next = cur;
                //minVal后移
                minVal = minVal.next;
            } else {
                //把cur的当前节点放到maxVal的后面
                maxVal.next = cur;
                //maxVal后移
                maxVal = maxVal.next;
            }
            cur = cur.next;
        }
        //防止形成环
        maxVal.next = null;
        //连接两个链表
        minVal.next = maxHead.next;
        //返回新的头节点
        return minHead.next;
    }
}