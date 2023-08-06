package leetcode;

import java.util.Stack;

/*
给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。

请你计算该表达式。返回一个表示表达式值的整数。

注意：

有效的算符为 '+'、'-'、'*' 和 '/' 。
每个操作数（运算对象）都可以是一个整数或者另一个表达式。
两个整数之间的除法总是 向零截断 。
表达式中不含除零运算。
输入是一个根据逆波兰表示法表示的算术表达式。
答案及所有中间计算结果可以用 32 位 整数表示。
 */
class Solution2 {
    /**
     * 思路分析：使用栈来进行，遇到数字字符串转化为数字后入栈，遇到运算符出栈两个数字，第一个数字作为右操作数，第二个作为左操作数
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param tokens 给定字符串数组
     * @return 返回结果
     */
    public int evalRPN(String[] tokens) {
        //申请栈
        Stack<Integer> stack = new Stack<>();
        //遍历字符串数组
        for (String s : tokens) {
            //不是运算符
            if (!isOperation(s)) {
                //转化为整型入栈
                stack.push(Integer.parseInt(s));
            } else {
                //是运算符
                //第一个作为右元素
                //第二个作为左元素
                int num1 = stack.pop();
                int num2 = stack.pop();

                //根据对应的运算符进行运算
                switch (s) {
                    case "+":
                        stack.push(num2 + num1);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num2 * num1);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                }
            }
        }
        //最后弹出结果
        return stack.pop();
    }

    //判断是不是运算符
    private boolean isOperation(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        }
        return false;
    }
}