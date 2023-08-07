package leetcode2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
class Solution {
    /**
     * 法一：转化为顺序表后比较值
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        if (head == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            if (list.get(left) == list.get(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 法二：栈
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;

        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            if (stack.peek() == cur.val) {
                stack.pop();
                cur = cur.next;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 法三：快慢指针 + 反转链表
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        //判空
        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        //找到中间结点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //若是总的是奇数结点，那么slow往下在走一步
        if (fast != null) {
            slow = slow.next;
        }

        //反转slow及以后的结点
        slow = reverse(slow);

        //进行结点之间的比较
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    //反转结点
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        //头插法
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}