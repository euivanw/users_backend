package dev.ivanwilhelm.users.domain.users;

import dev.ivanwilhelm.users.shared.CoreException;

public class UsersException extends CoreException {
    public UsersException(String message) {
        super(message);
    }

    public UsersException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsersException(Throwable cause) {
        super(cause);
    }
}
