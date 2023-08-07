package leetcode2;

import java.util.Stack;

/**
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，
 * 只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 */
class Solution1 {
    /**
     * 思路分析：模拟 -> 使用栈来模拟出栈顺序和入栈顺序，把pushed的元素进行入栈，入完栈后要和popped数组的元素进行比较
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param pushed 入栈数组
     * @param popped 出栈数组
     * @return 返回true/false
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //申请栈
        Stack<Integer> stack = new Stack<>();
        //用于遍历popped数组
        int j = 0;
        //遍历pushed数组
        for (int k : pushed) {
            //入栈
            stack.push(k);

            //栈顶元素和popped数组的元素进行判断，相等则出栈且让popped指向下一个元素
            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        //最后判断栈是否为空
        return stack.isEmpty();
    }
}