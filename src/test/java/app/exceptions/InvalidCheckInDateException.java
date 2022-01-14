package app.exceptions;

public class InvalidCheckInDateException extends Exception {
    public InvalidCheckInDateException(String errorMessage) {
        super(errorMessage);
    }
}
