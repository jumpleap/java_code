package leetcode;

import java.util.Stack;

/**
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            //判断是不是基本运算符
            if (!isOperation(s)) {
                //不是基本运算符直接入栈
                stack.push(Integer.parseInt(s));
            } else {
                //是基本运算符
                //弹出的第一个值是右值，第二个值是左值
                int right = stack.pop();
                int left = stack.pop();
                //基本运算符进行匹配，进行相应的操作
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
        //最后跳出结果
        return stack.peek();
    }

    //判断是不是基本运算符
    private boolean isOperation(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        }
        return false;
    }
}
