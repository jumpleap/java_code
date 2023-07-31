package leetcode;

import java.util.Stack;

/*
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */
public class ValidateStackSequences {
    /**
     * 思路分析：使用一个辅助栈，遍历pushed数组，让栈入pushed的数组元素，然后每次入的元素与popped的元素进行比较，相同则出栈
     * 最后遍历完pushed数组后，判断栈是否为空，为空则为true，非空false
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();//辅助栈

        int i = 0;
        //遍历数组
        for (int num : pushed) {
            stack.push(num);//入栈
            //判断栈顶元素是否和popped[i]的值相同，相同即出栈且让popped的数组元素走向下一个
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        //判断是否为空，空为true，非空false
        return stack.isEmpty();
    }
}