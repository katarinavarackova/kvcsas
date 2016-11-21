package com.varackova.transparentaccounts;

import android.app.Application;
import android.widget.Toast;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.varackova.transparentaccounts.rest.BusProvider;
import com.varackova.transparentaccounts.rest.AccountsInterface;
import com.varackova.transparentaccounts.rest.ApiCaller;
import com.varackova.transparentaccounts.rest.event.ErrorEvent;
import com.varackova.transparentaccounts.rest.ApiService;

/**
 * Application class.
 *
 * Creates service for rest api calls.
 * Communication is event driven using Otto.
 * Handles api errors.
 */
public class AccountsApplication extends Application {

    private Bus mBus = BusProvider.getInstance();

    @Override
    public void onCreate() {
        super.onCreate();

        AccountsInterface apiInterface = ApiCaller.getClient().create(AccountsInterface.class);
        ApiService apiService = new ApiService(apiInterface, mBus);

        mBus.register(apiService);
        mBus.register(this);
    }

    @Subscribe
    public void onError(ErrorEvent event) {
        Toast.makeText(this, R.string.api_error + event.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
