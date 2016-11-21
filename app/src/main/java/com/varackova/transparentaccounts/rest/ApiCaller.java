package com.varackova.transparentaccounts.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Caller for rest calls that builds Retrofit singleton instance using BASE_URL
 * and GsonConverter
 */
public class ApiCaller {

    public static final String BASE_URL = "https://api.csas.cz";
    private static Retrofit mRetrofit = null;

    public ApiCaller() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();
    }

    public static Retrofit getClient() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
