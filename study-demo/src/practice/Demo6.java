package practice;

import java.util.ArrayDeque;
import java.util.Deque;

// leetcode代码练习
public class Demo6 {
    /*
        给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
        链接: https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/description/
        链接: https://leetcode.cn/problems/3u1WK4/description/
     */

    /**
     * 思路分析: 快慢指针
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;

        //获取两个链表的长度
        int len1 = getLen(headA);
        int len2 = getLen(headB);
        int gap = len1 - len2;//长度的差值

        //让l1永远指向最长的那个链表
        if (len1 < len2) {
            l1 = headB;
            l2 = headA;
            gap = -gap;//gap取相反数
        }

        //让l1先走gap步
        for (int i = 0; i < gap; i++) {
            l1 = l1.next;
        }

        //两个一起走
        while (l1 != l2 && l1 != null && l2 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        //返回相交的结点
        return l1;
    }

    //计算链表的长度
    private int getLen(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    /*
        给你一个链表的头节点 head 。
        移除每个右侧有一个更大数值的节点。
        返回修改后链表的头节点 head 。
        链接: https://leetcode.cn/problems/remove-nodes-from-linked-list/description/
     */

    /**
     * 思路分析: 使用双端队列来模拟栈, 比栈顶元素大的值全部入栈(把栈中比它小的值全部弹出), 比栈顶元素小的入栈
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param head
     * @return
     */
    public ListNode removeNodes(ListNode head) {
        // 遍历节点
        ListNode cur = head;
        // 双端队列模拟栈
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode dummy = new ListNode();

        // 遍历链表
        while (cur != null) {
            // 栈不为空且栈顶元素比cur的值小的话, 弹出所有比cur值小的元素
            while (!stack.isEmpty() && cur.val > stack.peekLast().val) {
                stack.pollLast();
            }
            // 栈为空后添加, 栈顶元素比cur.val大的话添加
            stack.addLast(cur);
            cur = cur.next;
        }

        // 结果链表
        ListNode ans = dummy;
        // 判断栈空
        while (!stack.isEmpty()) {
            // 获取栈的前面元素,因为是逆置的
            ans.next = stack.pollFirst();
            ans = ans.next;
        }
        // 返回新链表
        return dummy.next;
    }
}
