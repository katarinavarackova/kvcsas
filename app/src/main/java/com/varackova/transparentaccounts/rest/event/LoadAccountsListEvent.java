package com.varackova.transparentaccounts.rest.event;

/**
 * Event posted to load list of accounts
 */
public class LoadAccountsListEvent {
    private int mPage;

    public LoadAccountsListEvent(int page) {
        mPage = page;
    }

    public int getPage() {
        return mPage;
    }
}
