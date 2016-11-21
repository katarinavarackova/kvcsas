
package com.varackova.transparentaccounts.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Structure for transactions
 */
public class Transactions {

    @SerializedName("pageNumber")
    @Expose
    private Integer pageNumber;
    @SerializedName("pageSize")
    @Expose
    private Integer pageSize;
    @SerializedName("pageCount")
    @Expose
    private Integer pageCount;
    @SerializedName("recordCount")
    @Expose
    private Integer recordCount;
    @SerializedName("transactions")
    @Expose
    private List<Transaction> transactions = new ArrayList<Transaction>();

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
     * @return The transactions
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * @param transactions The transactions
     */
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}