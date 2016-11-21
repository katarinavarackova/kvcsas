package com.varackova.transparentaccounts.rest.event;

import com.varackova.transparentaccounts.data.Account;

/**
 * Event posted when detail of account is loaded
 */
public class AccountDetailLoadedEvent {
    private Account mAccount;

    public AccountDetailLoadedEvent(Account account) {
        mAccount = account;
    }

    public Account getAccountDetail() {
        return mAccount;
    }
}
