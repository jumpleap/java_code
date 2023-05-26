package leetcode;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 */
public class AddTwoNumbers {
    /**
     * 思路分析：若是两个链表的长度相同，那么挨个计算即可；若是其中产生进位后，需要把当前的进位放到下一个位置处
     * 若长度不一样，那么直接把最长的那个链表放在后面，若有进位的产生，则需要添加对应的值到链表中
     * 时间复杂度：O(n)  空间复杂度：O(1)
     */
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode cur = new ListNode(-1);
        ListNode result = cur;
        int ret = 0;

        while (head1 != null || head2 != null || ret != 0) {
            //如果cur1不为null，则把cur1的val添加到ret中
            if (head1 != null) {
                ret += head1.val;
                head1 = head1.next;
            }

            //如果cur2不为null，则把cur2的val添加到ret中
            if (head2 != null) {
                ret += head2.val;
                head2 = head2.next;
            }

            //申请临时结点，存储当前位的值
            ListNode tmp = new ListNode(ret % 10);
            //让cur指向临时结点，并走下一步
            cur.next = tmp;
            cur = cur.next;
            //超过10的值需要进位
            ret /= 10;
        }
        //返回新的头节点
        return result.next;
    }
}