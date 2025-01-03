package exceptions; // You can place this class in a package named exceptions.
import enums.*;
public class SubscriberException extends RuntimeException { // Use Exception if you prefer checked exceptions
    private final ErrorCode errorCode;

    public SubscriberException(ErrorCode errorCode) {
        super("Error occurred: " + errorCode);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
