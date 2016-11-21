package com.varackova.transparentaccounts.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Structure for transaction sender
 */
public class Sender {

    @SerializedName("accountNumber")
    @Expose
    private String accountNumber;
    @SerializedName("iban")
    @Expose
    private String iban;
    @SerializedName("constantSymbol")
    @Expose
    private String constantSymbol;

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

    /**
     * @return The constantSymbol
     */
    public String getConstantSymbol() {
        return constantSymbol;
    }

    /**
     * @param constantSymbol The constantSymbol
     */
    public void setConstantSymbol(String constantSymbol) {
        this.constantSymbol = constantSymbol;
    }

}