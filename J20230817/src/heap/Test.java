package heap;

public class Test {
    public static void main(String[] args) {
        MyHeap myHeap = new MyHeap();
        int[] array = new int[]{3,5,1,4,8,2,9};
        myHeap.initHeap(array);
        myHeap.createHeap();

        myHeap.offer(12);
        myHeap.offer(11);
        myHeap.offer(23);
        myHeap.offer(18);
        System.out.println("====");

        System.out.println(myHeap.poll());
        System.out.println(myHeap.poll());
        System.out.println(myHeap.poll());

        System.out.println(myHeap.peek());
        System.out.println(myHeap.peek());

        myHeap.heapSort();
        System.out.println();
    }
}
