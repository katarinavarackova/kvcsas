package com.varackova.transparentaccounts.rest.event;

/**
 * Event posted to load transactions on account
 */
public class LoadAccountTransactionsEvent {
    private String mAccountNumber;
    private int mPage;

    public LoadAccountTransactionsEvent(String accountNumber, int page) {
        mAccountNumber = accountNumber;
        mPage = page;
    }

    public String getAccountNumber() {
        return mAccountNumber;
    }

    public int getPage() {
        return mPage;
    }
}
