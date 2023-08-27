package leetcode;

import java.util.Stack;

/**
 *给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，
 * 只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 */
class Solution3 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //申请栈
        Stack<Integer> stack = new Stack<>();
        //用于遍历popped数组
        int j = 0;
        //遍历pushed数组
        for (int i = 0; i < pushed.length; i++) {
            //入栈
            stack.push(pushed[i]);

            //栈顶元素和popped数组的元素进行判断，相等则出栈且让poped指向下一个元素
            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        //最后判断栈是否为空
        return stack.isEmpty();
    }
}