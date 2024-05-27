package ds.queue;

public class QueueIsEmpty extends RuntimeException {
    public QueueIsEmpty() {
    }

    public QueueIsEmpty(String message) {
        super(message);
    }
}
