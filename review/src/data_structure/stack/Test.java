package data_structure.stack;

/**
 * @Author 林沐雨
 * @Date 2025/4/30
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        MyStack stack = new MyStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.display();

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());

        System.out.println(stack.peek());
        System.out.println(stack.empty());
    }
}
