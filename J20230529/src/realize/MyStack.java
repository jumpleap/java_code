package realize;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * 那个队列不为空，就把值入到那个队列中去，默认入到q1队列中去
     */
    public void push(int x) {
        if (!q1.isEmpty()) {
            q1.offer(x);
        } else if (!q2.isEmpty()) {
            q2.offer(x);
        } else {
            q1.offer(x);
        }
    }

    public int pop() {
        if (empty()) {
            return -1;
        }

        if (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size - 1; i++) {
                int tmp = q1.poll();
                q2.offer(tmp);
            }
            return q1.poll();
        } else {
            int size = q2.size();
            for (int i = 0; i < size - 1; i++) {
                int tmp = q2.poll();
                q1.offer(tmp);
            }
            return q2.poll();
        }
    }

    public int top() {
        //判空
        if (empty()) {
            return -1;
        }

        int tmp = -1;
        if (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                tmp = q1.poll();
                q2.offer(tmp);
            }
        } else {
            int size = q2.size();
            for (int i = 0; i < size; i++) {
                tmp = q2.poll();
                q1.offer(tmp);
            }
        }
        return tmp;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
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