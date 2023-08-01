package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 */
class MyStack {
    Queue<Integer> queue1;//功能栈
    Queue<Integer> queue2;//辅助栈

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);//元素入队到queue2，即这个元素是栈顶元素
        //queue1不为空，则把queue1中的元素全部入到queue2的后面
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        //到这个地方：queue2中已经入好queue1的元素，queue1为空

        //交换
        //queue1是空
        Queue<Integer> tmp = queue1;
        //让queue1指向queue2，即queue1中有了已经入好了队的全部元素
        queue1 = queue2;
        //让queue2为空
        queue2 = tmp;
    }

    public int pop() {
        //queue1队列中添加了的元素全部倒置了，直接返回队头元素【即栈顶元素】
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        //判断queue1队列是否为空
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */