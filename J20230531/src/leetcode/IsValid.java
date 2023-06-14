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
    /**
     * 思路分析：左括号入栈，右括号则检查栈顶元素是否为左括号，进行匹配检查，若匹配，则弹出栈顶元素，反之，返回false
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * @param s 字符串
     * @return 布尔值
     */
    public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            //左括号即入栈
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else {
                //第一个元素是右括号且栈内为空
                if (stack.empty()) {
                    return false;
                }

                //获取栈顶元素
                char tmp = stack.peek();
                //判断左右括号是否匹配
                if ((tmp == '(' && ch == ')')
                        || (tmp == '[' && ch == ']')
                        || (tmp == '{' && ch == '}')) {
                    //匹配则跳出对应的左括号
                    stack.pop();
                } else {
                    //不匹配则返回false
                    return false;
                }
            }
        }
        //判断栈是否为空，空则返回true
        return stack.empty() ? true : false;
    }
}
