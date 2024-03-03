package data_structure.stack;

import java.util.Stack;

// 栈的相关算法题
public class LeetCode {
    /**
     * 逆序打印链表
     * 法一: 递归
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     */
    public void printReverse1(Node head) {
        // head不为空, 进行递归
        if (null != head) {
            // 进行递归
            printReverse(head.next);
            // 打印值
            System.out.print(head.val + " ");
        }
    }

    /**
     * 逆序打印链表
     * 法二: 栈辅助
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     */
    public void printReverse(Node head) {
        // 判空
        if (head == null) return;
        // 创建栈
        Stack<Node> stack = new Stack<>();

        // 入栈
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        // 出栈并打印值, 这个打印就是逆序打印
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.print(pop.val + " ");
        }
    }

    /**
     * 有效的括号
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     */
    public boolean isValid(String s) {
        // 字符串长度
        int len = s.length();
        // 创建栈
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            // 获取当前字符
            char ch = s.charAt(i);
            // 左括号入栈
            if (isLeftBracket(ch)) {
                stack.push(ch);
            } else {
                // 右括号
                // 空栈则无法匹配, 返回false
                if (stack.isEmpty()) {
                    return false;
                }

                // 不是空栈则进行括号匹配
                char tmp = stack.peek();
                // 判断左右是否匹配
                if (isMatches(tmp, ch)) {
                    stack.pop();
                } else {
                    // 不匹配则返回false
                    return false;
                }
            }
        }
        // 全部是左括号的情况
        return stack.isEmpty();
    }

    /**
     * 判断是不是左括号
     */
    private boolean isLeftBracket(char ch) {
        return ch == '[' || ch == '(' || ch == '{';
    }

    /**
     * 判断左右括号是否匹配
     */
    private boolean isMatches(char tmp, char ch) {
        if ((tmp == '[' && ch == ']') || (tmp == '{' && ch == '}')
                || (tmp == '(' && ch == ')')) {
            return true;
        }
        return false;
    }


    /**
     * 逆波兰表达式
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     */
    public int evalRPN(String[] tokens) {
        // 获取数组长度
        int len = tokens.length;
        // 创建栈
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            String s = tokens[i];
            // 数字则入栈
            if (isNumber(s)) {
                // 把字符串转为数字后入栈
                stack.push(Integer.parseInt(s));
            } else {
                // 弹出元素
                int right = stack.pop();
                int left = stack.pop();
                // 使用操作符进行操作
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
        // 返回结果
        return stack.pop();
    }

    /**
     * 判断当前字符串是不是数字
     */
    private boolean isNumber(String s) {
        return !("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s));
    }
}