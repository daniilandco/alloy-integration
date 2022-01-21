package com.github.daniilandco.alloyintegration.exception;

public class DatabaseFailureException extends Exception {
    public DatabaseFailureException() {
    }

    public DatabaseFailureException(String message) {
        super(message);
    }

    public DatabaseFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseFailureException(Throwable cause) {
        super(cause);
    }

    public DatabaseFailureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
