package pq.empm.ex;

public class BaseEx  extends RuntimeException {
    public BaseEx() {
        super();
    }

    public BaseEx(String message) {
        super(message);
    }

    public BaseEx(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseEx(Throwable cause) {
        super(cause);
    }

    protected BaseEx(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
