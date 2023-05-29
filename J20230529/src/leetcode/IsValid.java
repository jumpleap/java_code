package leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class IsValid {
    public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            //左括号则进栈
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                //第一个就是右括号的情况
                if (stack.empty()) {
                    return false;
                }
                //获取栈顶元素
                char tmp = stack.peek();
                //现在ch是右括号，tmp是栈顶元素
                if ((ch == ')' && tmp == '(') || (ch == ']' && tmp == '[')
                        || (ch == '}' && tmp == '{')) {
                    //删掉栈顶元素
                    stack.pop();
                } else {
                    //说明没有相匹配的左括号
                    return false;
                }
            }
        }

        //全部都是左括号的情况
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
