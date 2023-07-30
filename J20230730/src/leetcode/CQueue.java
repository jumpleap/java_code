package leetcode;
import java.util.Stack;

/*
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
class CQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    //添加到s1中去
    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        //判断s2是否为空
        if (!s2.empty()) {
            return s2.pop();//返回屁股元素，即队头元素即可
        } else {
            while (!s1.empty()) {
                s2.push(s1.pop());//把s1的值全部入到s2中
            }
            //判断s2是不是空，若不是空，直接返回队头元素，否则，返回-1
            return s2.empty() ? -1 : s2.pop();
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */