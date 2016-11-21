package com.varackova.transparentaccounts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.varackova.transparentaccounts.data.Account;
import com.varackova.transparentaccounts.data.AccountsList;
import com.varackova.transparentaccounts.rest.BusProvider;
import com.varackova.transparentaccounts.rest.event.AccountsListLoadedEvent;
import com.varackova.transparentaccounts.rest.event.LoadAccountsListEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Launcher activity
 * Shows list of accounts
 *
 * NOTE: There is no caching so after configuration change
 * it doesn't remember how many pages was shown
 */
public class AccountsListActivity extends AppCompatActivity {

    private static final String TAG = AccountsListActivity.class.getSimpleName();

    private List<Account> mAccountsList = new ArrayList<>();
    private AccountListAdapter mAdapter;
    private Bus mBus;

    private int mPage = 0;
    private boolean mFirstLoad = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_accounts);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new AccountListAdapter(mAccountsList, this);
        recyclerView.setAdapter(mAdapter);

        final Button loadMoreButton = (Button) findViewById(R.id.loadMoreButton);
        View.OnClickListener buttonOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMore();
            }
        };
        loadMoreButton.setOnClickListener(buttonOnClickListener);

        mBus = BusProvider.getInstance();
    }

    private void loadMore() {
        mBus.post(new LoadAccountsListEvent(mPage));
    }

    @Override
    public void onResume() {
        super.onResume();

        mBus.register(this);

        if (mFirstLoad) {
            loadMore();
            mFirstLoad = false;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mBus.unregister(this);
    }

    @Subscribe
    public void onAccountsListLoaded(AccountsListLoadedEvent event) {
        AccountsList accountsList = event.getAccountsList();
        List<Account> accounts = accountsList.getAccounts();
        if (accounts != null) {
            mAccountsList.addAll(accounts);
            mAdapter.notifyDataSetChanged();

            mPage = event.getAccountsList().getNextPage();
        }
    }

}