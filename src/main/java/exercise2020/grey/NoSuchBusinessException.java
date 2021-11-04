package exercise2020.grey;

/**
 * Exception to be thrown when the required business type is not configured
 * @author mtage
 * @since 2020/10/22 15:37
 */
public class NoSuchBusinessException extends IllegalArgumentException {
    public NoSuchBusinessException(String s) {
        super(s);
    }

    public NoSuchBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchBusinessException(Throwable cause) {
        super(cause);
    }
}
