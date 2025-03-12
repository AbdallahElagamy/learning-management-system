package com.app.lms.exception.custom;

import com.app.lms.exception.ErrorCode;

public class ValidationException extends RuntimeException {
    private final ErrorCode errorCode;

    public ValidationException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
