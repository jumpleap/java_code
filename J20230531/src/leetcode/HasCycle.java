package leetcode;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        //判断fast即fast.next是否非空
        while (fast != null && fast.next != null) {
            //fast走两步，slow走一步
            fast = fast.next.next;
            slow = slow.next;

            //存在环的情况下，判断fast和slow的结点是否相等
            if (fast == slow) {
                return true;
            }
        }
        //不存在环的情况
        return false;
    }
}