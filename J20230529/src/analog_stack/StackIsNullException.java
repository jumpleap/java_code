package analog_stack;

public class StackIsNullException extends RuntimeException {
    public StackIsNullException() {
    }

    public StackIsNullException(String message) {
        super(message);
    }
}
