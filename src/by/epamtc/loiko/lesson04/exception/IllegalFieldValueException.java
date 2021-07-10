package by.epamtc.loiko.lesson04.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
public class IllegalFieldValueException extends Exception {

    public IllegalFieldValueException(String message) {
        super(message);
    }

    public IllegalFieldValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalFieldValueException(Throwable cause) {
        super(cause);
    }

    public IllegalFieldValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}