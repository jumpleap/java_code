package leetcode;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution5 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param pHead1 ListNode类
     * @param pHead2 ListNode类
     * @return ListNode类
     */
    public ListNode Merge(ListNode pHead1, ListNode pHead2) {
        // connect用于连接
        ListNode connect = new ListNode(-1);
        // head用于返回
        ListNode head = connect;

        // 当pHead1和pHead2都为空跳出循环
        while (pHead1 != null || pHead2 != null) {
            if (pHead1 == null) { // pHead1没有节点了, 把pHead2的所有节点放在connect的后面
                connect.next = pHead2;
                break;
            } else if (pHead2 == null) { // pHead2没有节点了, 把pHead1的所有节点放在connect的后面
                connect.next = pHead1;
                break;
            } else if (pHead1.val < pHead2.val) { // pHead1的值小
                connect.next = pHead1;
                pHead1 = pHead1.next;
            } else { // pHead2的值小
                connect.next = pHead2;
                pHead2 = pHead2.next;
            }
            connect = connect.next;
        }

        // 返回链表
        return head.next;
    }
}