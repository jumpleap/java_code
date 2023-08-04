package leetcode;
/*
请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：

实现 MyQueue 类：

void push(int x) 将元素 x 推到队列的末尾
int pop() 从队列的开头移除并返回元素
int peek() 返回队列开头的元素
boolean empty() 如果队列为空，返回 true ；否则，返回 false
 */


import java.util.Stack;

/**
 * 思路分析：使用两个栈，一个栈只用于入元素，另一个栈只用于出元素，
 * 若出元素的栈中无元素，则把入元素栈的所有元素放入到出元素的栈中，此时，已经把元素翻转到了出元素栈中
 */
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        //分配内存空间
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    //入队：s1只用于入栈
    public void push(int x) {
        s1.push(x);
    }

    //出队：s2用于出队，若是s2中无元素，则把s1中的元素全部添加到s2中
    public int pop() {
        //判断空
        if (empty()) {
            return -1;
        }
        //若s2为空，则把s1中的所有元素放入到s2中
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        //弹出栈顶元素并返回
        return s2.pop();
    }

    //获取队头元素
    public int peek() {
        //判空
        if (empty()) {
            return -1;
        }
        //若s2为空，则把s1中的所有元素放入到s2中
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        //返回栈顶元素
        return s2.peek();
    }

    //判断两个栈非空
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */