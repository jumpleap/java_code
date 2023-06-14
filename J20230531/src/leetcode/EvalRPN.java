package leetcode;

import java.util.Stack;

/**
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 */
public class EvalRPN {
    /**
     * 思路分析：字符串数组的中的数字字符，入栈；操作符则把两个数字字符出栈进行相应的操作，然后把结果入栈；最后得到的就是结果
     * 时间复杂度：O(n) 空间复杂度：O(1)
     * @param tokens 字符串数字
     * @return 结果
     */
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            String ch = tokens[i];
            //数字字符串
            if (!(ch.equals("+") || ch.equals("-")
                    || ch.equals("*") || ch.equals("/"))) {
                //转为数字，入栈
                stack.push(Integer.parseInt(ch));
            } else {
                //左右值
                int right = stack.pop();
                int left = stack.pop();
                //判断操作符类型，进行相应的操作
                switch (ch) {
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
        //返回结果
        return stack.peek();
    }
}