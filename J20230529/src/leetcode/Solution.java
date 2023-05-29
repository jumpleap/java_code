package leetcode;

import java.util.*;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * 1. 0<=pushV.length == popV.length <=1000
 * 2. -1000<=pushV[i]<=1000
 * 3. pushV 的所有数字均不相同
 */
public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            //让pushA入栈
            stack.push(pushA[i]);

            //如果stack不为空且stack的栈顶元素和popA中的元素相等时
            while (!stack.empty() && stack.peek() == popA[j]) {
                //跳出stack中的元素
                stack.pop();
                j++;
            }
        }
        //判断stack是否为空
        return stack.empty();
    }
}