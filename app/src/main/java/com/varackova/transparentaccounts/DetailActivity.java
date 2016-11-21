package com.varackova.transparentaccounts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.varackova.transparentaccounts.rest.BusProvider;
import com.varackova.transparentaccounts.rest.event.AccountDetailLoadedEvent;
import com.varackova.transparentaccounts.rest.event.LoadAccountDetailEvent;

/**
 * Shows detail of account
 */
public class DetailActivity extends AppCompatActivity {
    public static final String ACCOUNT_NUMBER = "ACCOUNT_NUMBER";
    private Bus mBus;

    private String mAccountNumber;

    private TextView mAccountNumberView;
    private TextView mAccountNameView;
    private TextView mBankCodeView;
    private TextView mBalanceView;
    private TextView mIbanView;
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mActivity = this;

        Intent intent = getIntent();
        mAccountNumber = intent.getStringExtra(ACCOUNT_NUMBER);

        mBus = BusProvider.getInstance();//todo parent for all activities with Bus and toolbar

        initViews();
    }

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
        mBus.post(new LoadAccountDetailEvent(mAccountNumber));
    }

    @Override
    public void onPause() {
        super.onPause();
        mBus.unregister(this);
    }

    private void initViews() {
        mAccountNumberView = (TextView) findViewById(R.id.accountNumber);
        mAccountNameView = (TextView) findViewById(R.id.accountName);
        mBankCodeView = (TextView) findViewById(R.id.bankCode);
        mBalanceView = (TextView) findViewById(R.id.balance);
        mIbanView = (TextView) findViewById(R.id.iban);

        Button showTransactionsButton = (Button) findViewById(R.id.showTransactions);
        View.OnClickListener buttonOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, TransactionsActivity.class);
                intent.putExtra(DetailActivity.ACCOUNT_NUMBER, mAccountNumber);
                startActivity(intent);
            }
        };
        showTransactionsButton.setOnClickListener(buttonOnClickListener);
    }

    @Subscribe
    public void onAccountDetailLoaded(AccountDetailLoadedEvent event) {
        mAccountNumberView.setText(event.getAccountDetail().getAccountNumber());
        mAccountNameView.setText(event.getAccountDetail().getName());
        mBankCodeView.setText(event.getAccountDetail().getBankCode());
        mBalanceView.setText(String.valueOf(event.getAccountDetail().getBalance()) + event.getAccountDetail().getCurrency());
        mIbanView.setText(event.getAccountDetail().getIban());
    }

}
