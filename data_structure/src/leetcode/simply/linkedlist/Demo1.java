package leetcode.simply.linkedlist;

import leetcode.util.ListNode;

// 反转链表II
public class Demo1 {
    /*
        给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
        请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
        链接: https://leetcode.cn/problems/reverse-linked-list-ii/description/
     */

    /**
     * 思路分析: 模拟 + 头插法
     * 思路: 申请dummy节点,让dummy节点走到待反转的前一个节点, 申请end节点, 让end节点走到要反转的节点处
     * 从left到right处开始反转链表, 反转前先记录当前头节点的位置, 为了后续链接后续节点
     * 反转结束后, 进行代码的连接, 先连接后半部分, 再连接前半部分, 最后返回新链表
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // left和right相等说明无需反转, head为空直接返回
        if (left == right || head == null)
            return head;

        // 初始化节点
        ListNode dummy = new ListNode();
        ListNode newHead = dummy;
        dummy.next = head;
        ListNode end = head;

        // 让dummy节点走到要反转的前一个节点
        // 让end节点走到要反转的节点处
        for (int i = 0; i < left - 1; i++) {
            dummy = dummy.next;
            end = end.next;
        }

        // 从left往right处开始反转
        ListNode cur = end.next;
        ListNode curNext = null;
        // 获取当前end节点, 反转后未最后一个节点, 用于连接后面的节点
        ListNode tail = end;

        for (int i = left; i < right; i++) {
            // 获取cur的下一个节点
            curNext = cur.next;
            // 反转
            cur.next = end;
            end = cur;
            // 指向下一个节点
            cur = curNext;
        }
        // 连接后半部分的节点
        tail.next = curNext;
        // 连接前半部分的节点
        dummy.next = end;
        // 返回反转后的链表
        return newHead.next;
    }
}
