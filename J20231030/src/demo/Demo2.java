package demo;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue<Person> myBlockingQueue = new MyBlockingQueue<>();
        myBlockingQueue.put(new Person());
        myBlockingQueue.put(new Person());
        myBlockingQueue.put(new Person());
        myBlockingQueue.put(new Person());
        myBlockingQueue.put(new Person());
        myBlockingQueue.put(new Person());
        myBlockingQueue.put(new Person());
        myBlockingQueue.put(new Person());
        myBlockingQueue.put(new Person());
        myBlockingQueue.put(new Person());
        myBlockingQueue.put(new Person());
        myBlockingQueue.put(new Person());

        System.out.println(myBlockingQueue.take());
        System.out.println(myBlockingQueue.take());
        System.out.println(myBlockingQueue.take());
        System.out.println(myBlockingQueue.take());
        System.out.println(myBlockingQueue.take());
    }
}

class Person {
    public String name;
}