package com.github.alebabai.jmp2k17.classloaders;

public class InvokerException extends RuntimeException {
    public InvokerException() {
    }

    public InvokerException(String message) {
        super(message);
    }

    public InvokerException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvokerException(Throwable cause) {
        super(cause);
    }

    public InvokerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
