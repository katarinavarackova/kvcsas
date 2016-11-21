package com.varackova.transparentaccounts.rest;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.varackova.transparentaccounts.data.Account;
import com.varackova.transparentaccounts.data.AccountsList;
import com.varackova.transparentaccounts.data.Transactions;
import com.varackova.transparentaccounts.rest.event.AccountDetailLoadedEvent;
import com.varackova.transparentaccounts.rest.event.TransactionsLoadedEvent;
import com.varackova.transparentaccounts.rest.event.AccountsListLoadedEvent;
import com.varackova.transparentaccounts.rest.event.ErrorEvent;
import com.varackova.transparentaccounts.rest.event.LoadAccountDetailEvent;
import com.varackova.transparentaccounts.rest.event.LoadAccountTransactionsEvent;
import com.varackova.transparentaccounts.rest.event.LoadAccountsListEvent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Service calls rest API and after response creates success or error event
 * that is delivered by bus to subscribing component (Activity).
 */
public class ApiService {
    public static final int TRANSACTIONS_SIZE = 10;
    public static final int ACCOUNTS_SIZE = 10;

    private AccountsInterface mApi;
    private Bus mBus;

    public ApiService(AccountsInterface api, Bus bus) {
        mApi = api;
        mBus = bus;
    }

    @Subscribe
    public void onLoadAccountsList(LoadAccountsListEvent event) {
        Call<AccountsList> call = mApi.getAccountList(ACCOUNTS_SIZE, event.getPage());
        call.enqueue(new Callback<AccountsList>() {
            @Override
            public void onResponse(Call<AccountsList> call, Response<AccountsList> response) {
                if (response.body() != null) {
                    mBus.post(new AccountsListLoadedEvent(response.body()));
                }
            }

            @Override
            public void onFailure(Call<AccountsList> call, Throwable t) {
                mBus.post(new ErrorEvent(t.getMessage()));
            }
        });
    }

    @Subscribe
    public void onLoadAccountDetail(LoadAccountDetailEvent event) {
        Call<Account> call = mApi.getAccountDetail(event.getAccountNumber());
        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if (response.body() != null) {
                    mBus.post(new AccountDetailLoadedEvent(response.body()));
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                mBus.post(new ErrorEvent(t.getMessage()));
            }
        });
    }


    @Subscribe
    public void onLoadAccountTransactions(LoadAccountTransactionsEvent event) {
        Call<Transactions> call = mApi.getAccountTransactions(
                event.getAccountNumber(), TRANSACTIONS_SIZE, event.getPage());
        call.enqueue(new Callback<Transactions>() {
            @Override
            public void onResponse(Call<Transactions> call, Response<Transactions> response) {
                if (response.body() != null) {
                    mBus.post(new TransactionsLoadedEvent(response.body()));
                }
            }

            @Override
            public void onFailure(Call<Transactions> call, Throwable t) {
                mBus.post(new ErrorEvent(t.getMessage()));
            }
        });
    }


    //todo check in onResponse if response.body is not null and if count is > 0 and if 200

}
