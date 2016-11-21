package com.varackova.transparentaccounts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.varackova.transparentaccounts.data.Transaction;

import java.util.List;

/**
 * Adapter for recycler view that shows list of transactions on account
 */
public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.AccountHolder> {

    private final List<Transaction> mList;
    private final Context mContext;

    TransactionsAdapter(final List<Transaction> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public AccountHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transaction_item, parent, false);

        return new AccountHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AccountHolder holder, int position) {
        final Transaction item = mList.get(position);

        //set text
        holder.amount.setText(String.valueOf(item.getAmount().getValue()) + " " + item.getAmount().getCurrency());
        holder.from.setText(item.getSender().getAccountNumber());
        holder.to.setText(item.getReceiver().getAccountNumber() + "/" + item.getReceiver().getBankCode());
        holder.dueDate.setText(item.getDueDate());
        holder.constantSymbol.setText(item.getSender().getConstantSymbol());
    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }


    public class AccountHolder extends RecyclerView.ViewHolder {
        final TextView amount, from, to, dueDate, constantSymbol;

        public AccountHolder(View itemView) {
            super(itemView);
            amount = (TextView) itemView.findViewById(R.id.amount);
            from = (TextView) itemView.findViewById(R.id.from);
            to = (TextView) itemView.findViewById(R.id.to);
            dueDate = (TextView) itemView.findViewById(R.id.dueDate);
            constantSymbol = (TextView) itemView.findViewById(R.id.constantSymbol);
        }

    }
}
