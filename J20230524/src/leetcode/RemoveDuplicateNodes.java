package leetcode;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 */
public class RemoveDuplicateNodes {
    /**
     * 思路分析：遍历整个链表，用链表的每一个结点和后面的结点进行比较，若是相同，则删除后面的结点
     * 时间复杂度：O(n^2)  空间复杂度：O(1)
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;

        while (cur != null) {
            ListNode fast = cur;
            while (fast.next != null) {
                //相等的话，直接让fast.next 指向fast.next.next
                if (cur.val == fast.next.val) {
                    fast.next = fast.next.next;
                } else {
                    //不相等则正常走
                    fast = fast.next;
                }
            }
            //遍历整个链表
            cur = cur.next;
        }
        return head;
    }
}