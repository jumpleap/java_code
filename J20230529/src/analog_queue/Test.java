package analog_queue;

public class Test {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        myQueue.display();

        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        myQueue.display();

        System.out.println(myQueue.peek());
    }
}