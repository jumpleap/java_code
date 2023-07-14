package priority_queue;

public class Test {
    public static void main(String[] args) {
        PriorityQueueMock priorityQueueMock = new PriorityQueueMock();
        priorityQueueMock.offer(12);
        priorityQueueMock.offer(2);
        priorityQueueMock.offer(4);
        priorityQueueMock.offer(6);
        System.out.println(priorityQueueMock.poll());
        System.out.println(priorityQueueMock.isEmpty());
        System.out.println(priorityQueueMock.peek());
        System.out.println();
    }
}
