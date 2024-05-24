package ds.stack;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        System.out.println(stack.empty());
        System.out.println(stack.size());

        // System.out.println(stack.peek());
        // System.out.println(stack.pop());

        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.display();

        System.out.println(stack.empty());
        System.out.println(stack.peek());
        stack.display();
        stack.pop();
        stack.display();
    }
}
