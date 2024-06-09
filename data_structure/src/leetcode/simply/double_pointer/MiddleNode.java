package leetcode.simply.double_pointer;

import leetcode.util.ListNode;

// 获取链表中间节点和删除链表中间节点
public class MiddleNode {
    /*
        给你单链表的头结点 head ，请你找出并返回链表的中间结点。
        如果有两个中间结点，则返回第二个中间结点。
        https://leetcode.cn/problems/middle-of-the-linked-list/description/
     */

    /**
     * 快慢指针
     * 思路：定义快慢指针fast，slow，fast每次走两步，slow每次走一步，fast走到链表末尾，slow走到中间节点
     * 时间复杂度：O(N)
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        // 定义快慢指针
        ListNode fast = head;
        ListNode slow = head;

        // fast为空跳出，或fast.next为空跳出
        while(fast != null && fast.next != null) {
            // 快指针每次走两步
            fast = fast.next.next;
            // 慢指针每次走一步
            slow = slow.next;
        }
        // 返回中间结果
        return slow;
    }


    /*
        给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
        https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/description/
     */

    /**
     * 双指针 -- 快慢指针
     * 思路：定义快慢指针fast，slow，使用prev指向slow的前一个节点；
     *      fast每次走两步，slow每次走一步，prev指向slow的前一个，fast走到链表末尾，slow走到中间节点
     *      prev指向中间节点的前一个节点，进行删除中间节点
     * 时间复杂度：O(N)
     * @param head
     * @return
     */
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head;
        // 最后到达中间节点
        ListNode slow = head;
        // 指向slow的前一个节点
        ListNode prev = new ListNode();
        ListNode dummy = prev;


        // 当快指针遇到空跳出循环
        while (fast != null && fast.next != null) {
            // fast每次走两步
            fast = fast.next.next;
            // prev指向slow的前一个节点
            prev.next = slow;
            prev = prev.next;
            // slow每次走一步
            slow = slow.next;

        }
        // 删除中间节点
        prev.next = slow.next;
        // 返回结果
        return dummy.next;
    }

    /**
     * 遍历 + 双指针
     * 思路：获取链表长度得到中间节点，使用双指针；
     *      cur遍历指针，dummy连接指针，dummy指向cur的前一个节点，用于删除中间节点
     * 时间复杂度：O(N)
     * @param head
     * @return
     */
    public ListNode deleteMiddle1(ListNode head) {
        // 获取数组长度
        int len = getLength(head);
        // 获取中间节点
        int mid = len / 2;
        // 连接节点
        ListNode dummy = new ListNode();
        ListNode newHead = dummy;
        ListNode cur = head;

        // 遍历节点，到中间节点，dummy指向中间节点的前一个节点
        for (int i = 0; i < mid; i++) {
            dummy.next = cur;
            cur = cur.next;
            dummy = dummy.next;
        }

        // 进行中间节点的删除
        dummy.next = cur.next;
        return newHead.next;
    }

    // 获取链表长度
    private int getLength(ListNode head) {
        int count = 0;

        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
