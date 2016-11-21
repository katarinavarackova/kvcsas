
package com.varackova.transparentaccounts.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Structure for list of accounts
 */
public class AccountsList {

    @SerializedName("pageNumber")
    @Expose
    private Integer pageNumber;
    @SerializedName("pageSize")
    @Expose
    private Integer pageSize;
    @SerializedName("pageCount")
    @Expose
    private Integer pageCount;
    @SerializedName("nextPage")
    @Expose
    private Integer nextPage;
    @SerializedName("recordCount")
    @Expose
    private Integer recordCount;
    @SerializedName("accounts")
    @Expose
    private java.util.List<Account> accounts = new ArrayList<>();

    /**
     * @return The pageNumber
     */
    public Integer getPageNumber() {
        return pageNumber;
    }

    /**
     * @param pageNumber The pageNumber
     */
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * @return The pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize The pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return The pageCount
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     * @param pageCount The pageCount
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * @return The nextPage
     */
    public Integer getNextPage() {
        return nextPage;
    }

    /**
     * @param nextPage The nextPage
     */
    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    /**
     * @return The recordCount
     */
    public Integer getRecordCount() {
        return recordCount;
    }

    /**
     * @param recordCount The recordCount
     */
    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    /**
     * @return The accounts
     */
    public java.util.List<Account> getAccounts() {
        return accounts;
    }

    /**
     * @param accounts The accounts
     */
    public void setAccounts(java.util.List<Account> accounts) {
        this.accounts = accounts;
    }

}