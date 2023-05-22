package leetcode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {
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

    /**
     * 那个元素小那个添加到前面，若是某个链表为空后，直接把另外一个链表添加到后面
     * 时间复杂度：O(n); 空间复杂度：O(1)
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //判断list1和list2是否非空
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        //cur用于连接两个链表，使其合成一个链表
        ListNode cur = new ListNode();
        ListNode head = cur;

        //那个链表为空后跳出
        while (list1 != null && list2 != null) {
            ListNode tmp = null;//辅助变量
            //判断那个小，那个小那个在前面
            if (list1.val < list2.val) {
                tmp = list1;
                list1 = list1.next;
            } else {
                tmp = list2;
                list2 = list2.next;
            }
            //cur连接这些结点
            cur.next = tmp;
            //让cur指向下一个结点
            cur = cur.next;
        }

        //那个链表为空，则把另一个链表连接到cur后面
        if (list1 == null) {
            cur.next = list2;
        }

        if (list2 == null) {
            cur.next = list1;
        }
        //返回连接后的起始地址
        return head.next;
    }
}