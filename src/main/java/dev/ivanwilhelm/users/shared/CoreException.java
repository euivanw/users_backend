package dev.ivanwilhelm.users.shared;

import java.io.Serial;

public class CoreException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public CoreException(String message) {
        super(message);
    }

    public CoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoreException(Throwable cause) {
        super(cause);
    }
}
