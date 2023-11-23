package data_sructure;

public class StackIsNullException extends RuntimeException {
    public StackIsNullException() {
    }

    public StackIsNullException(String message) {
        super(message);
    }
}
