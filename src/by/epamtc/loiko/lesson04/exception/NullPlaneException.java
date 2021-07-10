package by.epamtc.loiko.lesson04.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
public class NullPlaneException extends Exception {

    public NullPlaneException(String message) {
        super(message);
    }

    public NullPlaneException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullPlaneException(Throwable cause) {
        super(cause);
    }

    public NullPlaneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}