package arraylist;

public class MyArrayListIsEmptyException extends RuntimeException {
    public MyArrayListIsEmptyException() {
    }

    public MyArrayListIsEmptyException(String message) {
        super(message);
    }
}
