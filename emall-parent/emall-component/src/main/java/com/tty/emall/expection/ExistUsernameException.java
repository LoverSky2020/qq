package com.tty.emall.expection;

/**
 * @author tty
 * @create 2020-09-04-10:08
 */
public class ExistUsernameException extends RuntimeException {
    public ExistUsernameException() {
        super();
    }

    public ExistUsernameException(String message) {
        super(message);
    }

    public ExistUsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistUsernameException(Throwable cause) {
        super(cause);
    }

    protected ExistUsernameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
