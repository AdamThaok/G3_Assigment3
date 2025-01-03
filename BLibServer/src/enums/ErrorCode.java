package enums;

public enum ErrorCode {
    USER_ALREADY_EXISTS("The user already exists in the system."),
    ACCOUNT_FROZEN("The account is currently frozen."),
    USER_DOESNT_EXIST("The account does not exsist.");
    private final String message;

    // Constructor
    ErrorCode(String message) {
        this.message = message;
    }

    // Getter for the error message
    public String getMessage() {
        return message;
    }
}
