package datastruct;

/**
 * 空数组异常类
 */
public class EmptyArrayException extends RuntimeException {
    public EmptyArrayException() {

    }

    public EmptyArrayException(String message) {
        super(message);
    }
}