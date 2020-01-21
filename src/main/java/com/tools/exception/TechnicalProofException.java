package com.tools.exception;

public class TechnicalProofException extends Exception {

    private static final long serialVersionUID = 5440518284715618619L;

    private final String message;

    public TechnicalProofException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
