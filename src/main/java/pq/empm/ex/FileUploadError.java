package pq.empm.ex;

public class FileUploadError extends BaseEx {
    public FileUploadError() {
        super();
    }

    public FileUploadError(String message) {
        super(message);
    }

    public FileUploadError(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadError(Throwable cause) {
        super(cause);
    }

    protected FileUploadError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
