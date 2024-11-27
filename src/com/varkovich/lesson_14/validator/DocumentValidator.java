package com.varkovich.lesson_14.validator;

import com.varkovich.lesson_14.utils.DocumentValidationState;

public class DocumentValidator {

    public static DocumentValidationState validateDocument(String document) {
        if (document == null || document.isEmpty()) {
            return DocumentValidationState.INVALID_DOCUMENT_NULL_OR_EMPTY;
        }

        if (document.length() != 15) {
            return DocumentValidationState.INVALID_DOCUMENT_INCORRECT_LENGTH;
        }

        if (!document.startsWith("docnum") && !document.startsWith("contract")) {
            return DocumentValidationState.INVALID_DOCUMENT_SERVICE_SYMBOLS;
        }

        if (!document.matches("^[a-zA-Z0-9]+$")) {
            return DocumentValidationState.INVALID_DOCUMENT_SERVICE_SYMBOLS;
        }

        return DocumentValidationState.VALID_DOCUMENT;
    }
}
