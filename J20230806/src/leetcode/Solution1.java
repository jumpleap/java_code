package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
/*
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
class Solution1 {
    /**
     * 法一：栈 -> 把元素入栈后，使用数组接收栈弹出的元素
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head 给定的头节点
     * @return 返回数组
     */
    public int[] reversePrint1(ListNode head) {
        //判空
        if (head == null) {
            return new int[0];
        }

        //申请栈
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        //入栈
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        //申请数组
        int[] array = new int[stack.size()];
        int index = 0;

        //弹栈
        while (!stack.isEmpty()) {
            array[index++] = stack.pop();
        }
        return array;
    }


    //申请顺序表
    ArrayList<Integer> tmp = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        //判空
        if (head == null) {
            return new int[0];
        }

        //递归链表
        reverse(head);
        //申请数组
        int[] array = new int[tmp.size()];
        //数组赋值
        for (int i = 0; i < array.length; i++) {
            array[i] = tmp.get(i);
        }
        return array;
    }

    //递归链表
    private void reverse(ListNode head) {
        if (head == null) {
            return;
        }
        reverse(head.next);
        tmp.add(head.val);
    }
}