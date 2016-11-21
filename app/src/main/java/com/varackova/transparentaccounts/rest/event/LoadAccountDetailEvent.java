package com.varackova.transparentaccounts.rest.event;

/**
 * Event posted to load details of account
 */
public class LoadAccountDetailEvent {
    private String mAccountNumber;

    public LoadAccountDetailEvent(String accountNumber) {
        mAccountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return mAccountNumber;
    }
}
