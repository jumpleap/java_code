package analog_queue;

public class TestMyCircleQueue {
    public static void main(String[] args) {
        MyCircleQueue myCircleQueue = new MyCircleQueue(6);
        myCircleQueue.enQueue(1);
        myCircleQueue.enQueue(2);
        myCircleQueue.enQueue(3);
        myCircleQueue.enQueue(4);

        myCircleQueue.deQueue();
        myCircleQueue.deQueue();

        System.out.println(myCircleQueue.Front());
        System.out.println(myCircleQueue.Rear());
    }
}
