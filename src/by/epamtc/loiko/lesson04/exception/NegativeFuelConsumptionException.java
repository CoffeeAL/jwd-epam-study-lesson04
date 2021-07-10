package by.epamtc.loiko.lesson04.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
public class NegativeFuelConsumptionException extends Exception {

    public NegativeFuelConsumptionException(String message) {
        super(message);
    }

    public NegativeFuelConsumptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeFuelConsumptionException(Throwable cause) {
        super(cause);
    }

    public NegativeFuelConsumptionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}