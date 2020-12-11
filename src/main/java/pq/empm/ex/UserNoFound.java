package pq.empm.ex;

public class UserNoFound extends  BaseEx {

    public UserNoFound() {
        super();
    }

    public UserNoFound(String message) {
        super(message);
    }

    public UserNoFound(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNoFound(Throwable cause) {
        super(cause);
    }

    protected UserNoFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
