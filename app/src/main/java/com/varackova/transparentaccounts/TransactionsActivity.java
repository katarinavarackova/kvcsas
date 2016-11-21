package com.varackova.transparentaccounts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.varackova.transparentaccounts.data.Transaction;
import com.varackova.transparentaccounts.data.Transactions;
import com.varackova.transparentaccounts.rest.BusProvider;
import com.varackova.transparentaccounts.rest.event.LoadAccountTransactionsEvent;
import com.varackova.transparentaccounts.rest.event.TransactionsLoadedEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Shows transactions on account
 */
public class TransactionsActivity extends AppCompatActivity {

    private String mAccountNumber;
    private Bus mBus;
    private int mPage = 0;
    private List<Transaction> mTransactionsList = new ArrayList<>();
    private TransactionsAdapter mAdapter;
    private Button mLoadMoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Intent intent = getIntent();
        mAccountNumber = intent.getStringExtra(DetailActivity.ACCOUNT_NUMBER);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new TransactionsAdapter(mTransactionsList, this);
        recyclerView.setAdapter(mAdapter);

        mLoadMoreButton = (Button) findViewById(R.id.loadMoreButton);
        View.OnClickListener buttonOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMore();
            }
        };
        mLoadMoreButton.setOnClickListener(buttonOnClickListener);

        mBus = BusProvider.getInstance();//todo parent for all activities with Bus and toolbar

    }

    //todo move to parent
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onResume() {
        super.onResume();

        mBus.register(this);
        mBus.post(new LoadAccountTransactionsEvent(mAccountNumber, mPage));
    }

    @Override
    public void onPause() {
        super.onPause();
        mBus.unregister(this);
    }

    private void loadMore() {
        mBus.post(new LoadAccountTransactionsEvent(mAccountNumber, mPage));
    }

    @Subscribe
    public void onTransactionsLoaded(TransactionsLoadedEvent event) {
        Transactions transactionsList = event.getTransactions();
        List<Transaction> transactions = transactionsList.getTransactions();
        if (transactions != null) {
            mTransactionsList.addAll(transactions);
            mAdapter.notifyDataSetChanged();

            mPage = event.getTransactions().getPageNumber() + 1;

            if (event.getTransactions().getPageCount() == mPage) {
                mLoadMoreButton.setVisibility(View.GONE);
            }
        }
    }

}
