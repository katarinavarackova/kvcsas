package com.varackova.transparentaccounts.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Structure for transaction receiver
 */
public class Receiver {

    @SerializedName("accountNumber")
    @Expose
    private String accountNumber;
    @SerializedName("bankCode")
    @Expose
    private String bankCode;
    @SerializedName("iban")
    @Expose
    private String iban;

    /**
     * @return The accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber The accountNumber
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return The bankCode
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * @param bankCode The bankCode
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * @return The iban
     */
    public String getIban() {
        return iban;
    }

    /**
     * @param iban The iban
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

}