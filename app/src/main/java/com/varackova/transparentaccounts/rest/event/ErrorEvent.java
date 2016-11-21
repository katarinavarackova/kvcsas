package com.varackova.transparentaccounts.rest.event;

/**
 * Event for errors
 */
public class ErrorEvent {
    private String mErrorMessage;

    public ErrorEvent(String errorMessage) {
        mErrorMessage = errorMessage;
    }

    public String getMessage() {
        return mErrorMessage;
    }
}
