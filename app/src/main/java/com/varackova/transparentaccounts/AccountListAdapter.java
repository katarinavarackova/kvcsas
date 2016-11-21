package com.varackova.transparentaccounts;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.varackova.transparentaccounts.data.Account;

import java.util.List;

/**
 * Adapter for recycler view that shows list of accounts
 */
public class AccountListAdapter extends RecyclerView.Adapter<AccountListAdapter.AccountHolder> implements View.OnClickListener {

    private final List<Account> mList;
    private final Context mContext;

    AccountListAdapter(final List<Account> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public AccountHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.account_item, parent, false);

        return new AccountHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AccountHolder holder, int position) {
        final Account item = mList.get(position);

        //set text
        holder.accountNumberView.setText(item.getAccountNumber());
        holder.amountView.setText(item.getBalance() + " " +item.getCurrency());

        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    @Override
    public void onClick(View v) {
        String accountNumber = ((TextView) v.findViewById(R.id.accountNumber)).getText().toString();

        Intent intent = new Intent(mContext, DetailActivity.class);
        intent.putExtra(DetailActivity.ACCOUNT_NUMBER, accountNumber);
        mContext.startActivity(intent);
    }


    public class AccountHolder extends RecyclerView.ViewHolder {
        final TextView amountView;
        final TextView accountNumberView;

        public AccountHolder(View itemView) {
            super(itemView);
            accountNumberView = (TextView) itemView.findViewById(R.id.accountNumber);
            amountView = (TextView) itemView.findViewById(R.id.amount);
        }

    }
}
