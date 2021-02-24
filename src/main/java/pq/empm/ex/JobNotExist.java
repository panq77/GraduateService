package pq.empm.ex;

public class JobNotExist extends BaseEx{
    public JobNotExist() {
        super();
    }

    public JobNotExist(String message) {
        super(message);
    }

    public JobNotExist(String message, Throwable cause) {
        super(message, cause);
    }

    public JobNotExist(Throwable cause) {
        super(cause);
    }

    protected JobNotExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
