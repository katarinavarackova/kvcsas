package com.varackova.transparentaccounts.rest;

import com.varackova.transparentaccounts.data.Account;
import com.varackova.transparentaccounts.data.AccountsList;
import com.varackova.transparentaccounts.data.Transactions;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Interface for rest API calls
 */
public interface AccountsInterface {

    /**
     * Get all transparent accounts
     *
     * @param size - size of page
     * @param page - number of page
     * @return instance of AccountsList class
     */
    @Headers("WEB-API-key: 3887359e-2b6f-42d3-a6a8-b7e49be55c08")
    @GET("/sandbox/webapi/api/v2/transparentAccounts")
    Call<AccountsList> getAccountList(
            @Query("size") int size,
            @Query("page") int page);

    /**
     * Get detail of account
     *
     * @param id - id of account
     * @return instance of Account class
     */
    @Headers("WEB-API-key: 3887359e-2b6f-42d3-a6a8-b7e49be55c08")
    @GET("/sandbox/webapi/api/v2/transparentAccounts/{id}")
    Call<Account> getAccountDetail(
            @Path("id") String id
    );

    /**
     * Get transactions on account
     *
     * @param id   - id of account
     * @param size - size of page
     * @param page - number of page
     * @return instance of Transactions class
     */
    @Headers("WEB-API-key: 3887359e-2b6f-42d3-a6a8-b7e49be55c08")
    @GET("/sandbox/webapi/api/v2/transparentAccounts/{id}/transactions")
    Call<Transactions> getAccountTransactions(
            @Path("id") String id,
            @Query("size") int size,
            @Query("page") int page
    );

}
