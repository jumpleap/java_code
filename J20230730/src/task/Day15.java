package task;

import java.util.Stack;

public class Day15 {
    /*
    1、一棵有15个节点的完全二叉树和一棵同样有15个节点的普通二叉树，叶子节点的个数最多会差多少个？（C）
    A. 3 B. 5 C. 7 D. 9
    //解析：单边二叉树【普通二叉树的叶子节点就一个】

    2、在一棵二叉树中，假定每个结点只有左孩子，没有右孩子，对它分别进行前序遍历和后序遍历，则具有相同的
    遍历结果。（B）
    A. 正确 B. 错误
    //解析：只有左孩子，没有右孩子的二叉树的前序和后续遍历相反

    3、一棵满二叉树同时又是一棵平衡树。这种说法（A）
    A. 正确 B. 错误
    //平衡二叉树：左子树和右子树都是平衡的二叉树；每一个节点的左右子树的高度差<=1

    4、已知一棵二叉树的先序和中序遍历序列如下：先序：A、B、C、D、E、F、G、H、I，J中序：C、B、A、E、
    F、D、I、H、J、G其后序遍历序列为（E）
    A. C、B、D、E、A、G、I、H、J、F
    B. C、B、D、A、E、G、I、H、J、F
    C. C、E、D、B、I、J、H、G、F、A
    D. C、E、D、B、I、H、J、G、F、A
    E. C、B、F、E、I、J、H、G、D、A
    //解析：根据前序遍历和中序遍历构建二叉树，然后写出后续遍历

    5、完全二叉树中的叶子结点只可能在最后两层中出现 （A）
    A. 正确 B. 错误
     */

    /*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    每个右括号都有一个对应的相同类型的左括号。
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            //左括号均入栈
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                //若是空栈
                if (stack.isEmpty()) {
                    return false;
                }
                char tmp = stack.peek();
                //匹配直接出栈
                if (ch == ')' && tmp == '(' || ch == '}' && tmp == '{' || ch == ']' && tmp == '[') {
                    stack.pop();
                } else {
                    //不匹配的情况
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }

}

/*
    设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

    实现 MinStack 类:

    MinStack() 初始化堆栈对象。
    void push(int val) 将元素val推入堆栈。
    void pop() 删除堆栈顶部的元素。
    int top() 获取堆栈顶部的元素。
    int getMin() 获取堆栈中的最小元素。
*/

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);//入栈
        if (min.isEmpty()) {
            min.push(val);
            return;
        }
        if (val <= min.peek()) {
            //最小栈入栈
            min.push(val);
        }
    }

    public void pop() {
        //出栈
        int num = stack.pop();
        if (num == min.peek()) {
            //最小栈出栈
            min.pop();
        }
    }

    public int top() {
        //获取正常栈的栈顶元素
        return stack.peek();
    }

    public int getMin() {
        //获取最小栈的栈顶元素
        return min.peek();
    }
}