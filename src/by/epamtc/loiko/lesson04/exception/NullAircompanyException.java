package by.epamtc.loiko.lesson04.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
public class NullAircompanyException extends Exception {

    public NullAircompanyException(String message) {
        super(message);
    }

    public NullAircompanyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullAircompanyException(Throwable cause) {
        super(cause);
    }

    public NullAircompanyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}