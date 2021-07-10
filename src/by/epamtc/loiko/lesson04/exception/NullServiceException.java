package by.epamtc.loiko.lesson04.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
public class NullServiceException extends Exception {

    public NullServiceException(String message) {
        super(message);
    }

    public NullServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullServiceException(Throwable cause) {
        super(cause);
    }

    public NullServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}