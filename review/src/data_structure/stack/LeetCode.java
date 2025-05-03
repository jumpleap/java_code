package data_structure.stack;

import data_structure.linkedlist.linked.MyLinkedList;

import java.util.Stack;

/**
 * @Author 林沐雨
 * @Date 2025/4/30
 * @Description 栈相关题
 */
public class LeetCode {
    static class ListNode {
        private int val;
        private ListNode prev;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // 逆序打印链表
    // 法一：使用递归
    public void reverse(ListNode head) {
        if (head == null) {
            return;
        }
        reverse(head.next);
        System.out.println(head.val);

    }

    // 法二：使用栈
    public void reverse2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (!stack.empty()) {
            ListNode tmp = stack.pop();
            System.out.println(tmp.val + " ");
        }

    }

    //https://leetcode.cn/problems/valid-parentheses/description/
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char tmp = stack.peek();
                if ((tmp == '(' && c == ')') || (tmp == '{' && c == '}') || (tmp == '[' && c == ']')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();

    }

    //https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int len = tokens.length;

        for (int i = 0; i < len; i++) {
            String s = tokens[i];
            // 判断是不是数字
            if (isNumber(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                // 弹出的第一个数为右操作数
                int right = stack.pop();
                // 第二个为左操作数
                int left = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(left + right);
                        break;
                    case "-":
                        stack.push(left - right);
                        break;
                    case "*":
                        stack.push(left * right);
                        break;
                    case "/":
                        stack.push(left / right);
                        break;
                }
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String s) {
        if (!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))) {
            return true;
        }
        return false;
    }

    //https://leetcode.cn/problems/validate-stack-sequences/description/
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        Stack<Integer> stack = new Stack();
        int j = 0;

        for (int i = 0; i < len; i++) {
            stack.push(pushed[i]);

            while (!stack.empty() && j < len && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

    //https://leetcode.cn/problems/min-stack/description/
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack();
            minStack = new Stack();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.empty()) {
                minStack.push(val);
            } else {
                if (val <= minStack.peek()) {
                    minStack.push(val);
                }
            }
        }

        public void pop() {
            if (stack.empty()) return;
            int val = stack.pop();
            if (!minStack.empty() && val == minStack.peek()) {
                minStack.pop();
            }

        }

        public int top() {
            return stack.peek();

        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
