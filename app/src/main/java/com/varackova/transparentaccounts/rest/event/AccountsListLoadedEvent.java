package com.varackova.transparentaccounts.rest.event;

import com.varackova.transparentaccounts.data.AccountsList;

/**
 * Event posted when list of accounts is loaded
 */
public class AccountsListLoadedEvent {
    private AccountsList mAccountsList;

    public AccountsListLoadedEvent(AccountsList accountsList) {
        mAccountsList = accountsList;
    }

    public AccountsList getAccountsList() {
        return mAccountsList;
    }
}
