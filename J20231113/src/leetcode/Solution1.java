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

public class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 头插法
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode ReverseList(ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }

        ListNode cur = head.next;
        // 置空
        head.next = null;
        while (cur != null) {
            // 保存cur的下一个节点, 防止找不到节点
            ListNode curNext = cur.next;
            // 头插
            cur.next = head;
            head = cur;
            // 指向下一个节点
            cur = curNext;
        }

        return head;
    }
}