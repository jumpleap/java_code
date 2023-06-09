package leetcode;

public class RemoveNthFromEnd {
    /**
     * 快慢指针：不带头节点
     * @param head 头节点
     * @param n 倒数值
     * @return 返回值
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        //让fast先走n步
        for (int i = 0; i < n; i++) {
            //判断fast非空
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        //判断fast是否为空，若为空，则说明要删除第一个节点
        if (fast == null) {
            return slow.next;
        }

        //两个一起走，slow走到要删除的前一个位置
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 快慢指针：带头节点的
     * @param head 头节点
     * @param n    倒数第n个值
     * @return 返回值
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = cur;

        //让fast先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //让fast和slow一起走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //直接删除slow的下一个结点
        slow.next = slow.next.next;
        return cur.next;
    }
}