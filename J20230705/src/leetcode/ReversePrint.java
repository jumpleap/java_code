package leetcode;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class ReversePrint {
    /**
     * 数组模拟实现：获取链表长度，然后从尾开始填入数据
     * 时间复杂度、空间复杂度：O(n)
     * @param head 头节点
     * @return 返回数组
     */
    public int[] reversePrint1(ListNode head) {
        int len = getLen(head);//获取链表长度
        int[] arr = new int[len];//申请数组空间

        //给数组进行赋值，把链表中的数组添加到数组中去
        while (head != null) {
            arr[--len] = head.val;
            head = head.next;
        }
        return arr;
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

    /**
     * 栈的特点实现：先进后出，从栈顶到栈底是按照从尾遍历的顺序
     * 时间、空间复杂度：O(n)
     * @param head 头节点
     * @return 返回数组
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();//申请栈
        ListNode cur = head;

        //入栈
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        //申请数组
        int[] arr = new int[stack.size()];
        //数组中填充数据
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }
}