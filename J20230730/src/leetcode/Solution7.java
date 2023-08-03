package leetcode;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。
 */

import java.util.Stack;

class Solution7 {
    /**
     * 思路分析： 辅助栈 -> 使用辅助栈，遇到左括号入栈，遇到右括号判断栈顶元素是不是相对应的左括号，是则出栈，不是返回false
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param s 给定字符串
     * @return 返回true/false
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();//辅助栈
        int len = s.length();//字符串长度
        for (int i = 0; i < len; i++) {
            //获取字符串中的字每个字符
            char ch = s.charAt(i);
            //遇到了左括号
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);//入栈
            } else {
                //遇到了右括号且当前栈为空
                if (stack.isEmpty()) {
                    return false;
                }
                //获取当前栈的栈顶元素
                char tmp = stack.peek();
                //判断栈顶元素是不是左括号且与当前的右括号匹配
                if (judgeIsMatch(tmp, ch)) {
                    //匹配则出栈
                    stack.pop();
                } else {
                    //不匹配则说明左右括号不是正确的闭合顺序
                    return false;
                }
            }
        }
        //判断是否栈空
        return stack.isEmpty() ? true : false;
    }

    //判断是否左右括号是否匹配
    private boolean judgeIsMatch(char tmp, char ch) {
        //匹配
        if ((tmp == '(' && ch == ')') || (tmp == '{' && ch == '}')
                || (tmp == '[' && ch == ']')) {
            return true;
        }
        //不匹配
        return false;
    }
}