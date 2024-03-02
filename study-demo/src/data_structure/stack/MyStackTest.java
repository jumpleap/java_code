package data_structure.stack;

// 栈的代码测试
public class MyStackTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.peek());

        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
//        stack.pop();
    }
}
