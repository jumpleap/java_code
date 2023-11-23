package data_sructure;

public class Test {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        // System.out.println(stack.peek());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.size());

        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}