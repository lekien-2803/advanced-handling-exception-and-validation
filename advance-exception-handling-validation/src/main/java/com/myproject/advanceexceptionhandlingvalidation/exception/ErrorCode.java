package com.myproject.advanceexceptionhandlingvalidation.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_EXISTED(1001, "User existed."),
    EMAIL_EXISTED(1002, "Email existed."),
    USER_NOT_FOUND(1003, "User not found."),
    INVALID_USERNAME(1004, "Username must be at least 3 characters."),
    INVALID_PASSWORD(1005, "Password must be at least 8 characters."),
    INVALID_EMAIL(1006, "Invalid email."),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error."),
    INVALID_MESSAGE(8888, "Invalid message key.")
    ;
    private int code;
    private String message;
}
