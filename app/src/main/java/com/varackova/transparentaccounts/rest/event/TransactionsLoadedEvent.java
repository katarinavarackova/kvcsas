package com.varackova.transparentaccounts.rest.event;

import com.varackova.transparentaccounts.data.Transactions;

/**
 * Event posted when transactions on account are loaded
 */
public class TransactionsLoadedEvent {
    private Transactions mTransactions;

    public TransactionsLoadedEvent(Transactions transactions) {
        mTransactions = transactions;
    }

    public Transactions getTransactions() {
        return mTransactions;
    }
}
