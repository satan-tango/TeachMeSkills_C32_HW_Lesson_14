package com.varkovich.lesson_14.utils;

public enum DocumentValidationState {
    INVALID_DOCUMENT_INCORRECT_LENGTH("incorrect document length"),
    INVALID_DOCUMENT_INCORRECT_BEGGING("incorrect document begging"),
    INVALID_DOCUMENT_SERVICE_SYMBOLS("service symbols are not allowed"),
    INVALID_DOCUMENT_NULL_OR_EMPTY("document null or empty"),
    VALID_DOCUMENT("document is valid");

    private final String message;

    DocumentValidationState(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
