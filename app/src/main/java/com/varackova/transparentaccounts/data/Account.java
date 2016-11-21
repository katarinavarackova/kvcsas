package com.varackova.transparentaccounts.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

/**
 * Structure for account
 */
public class Account {

    @SerializedName("accountNumber")
    @Expose
    private String accountNumber;
    @SerializedName("bankCode")
    @Expose
    private String bankCode;
    @SerializedName("transparencyFrom")
    @Expose
    private String transparencyFrom;
    @SerializedName("transparencyTo")
    @Expose
    private String transparencyTo;
    @SerializedName("publicationTo")
    @Expose
    private String publicationTo;
    @SerializedName("actualizationDate")
    @Expose
    private String actualizationDate;
    @SerializedName("balance")
    @Expose
    private BigDecimal balance;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("iban")
    @Expose
    private String iban;
    @SerializedName("note")
    @Expose
    private String note;

    /**
     *
     * @return
     * The accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     *
     * @param accountNumber
     * The accountNumber
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     *
     * @return
     * The bankCode
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     *
     * @param bankCode
     * The bankCode
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    /**
     *
     * @return
     * The transparencyFrom
     */
    public String getTransparencyFrom() {
        return transparencyFrom;
    }

    /**
     *
     * @param transparencyFrom
     * The transparencyFrom
     */
    public void setTransparencyFrom(String transparencyFrom) {
        this.transparencyFrom = transparencyFrom;
    }

    /**
     *
     * @return
     * The transparencyTo
     */
    public String getTransparencyTo() {
        return transparencyTo;
    }

    /**
     *
     * @param transparencyTo
     * The transparencyTo
     */
    public void setTransparencyTo(String transparencyTo) {
        this.transparencyTo = transparencyTo;
    }

    /**
     *
     * @return
     * The publicationTo
     */
    public String getPublicationTo() {
        return publicationTo;
    }

    /**
     *
     * @param publicationTo
     * The publicationTo
     */
    public void setPublicationTo(String publicationTo) {
        this.publicationTo = publicationTo;
    }

    /**
     *
     * @return
     * The actualizationDate
     */
    public String getActualizationDate() {
        return actualizationDate;
    }

    /**
     *
     * @param actualizationDate
     * The actualizationDate
     */
    public void setActualizationDate(String actualizationDate) {
        this.actualizationDate = actualizationDate;
    }

    /**
     *
     * @return
     * The balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     *
     * @param balance
     * The balance
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     *
     * @return
     * The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     *
     * @param currency
     * The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The iban
     */
    public String getIban() {
        return iban;
    }

    /**
     *
     * @param iban
     * The iban
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     *
     * @return
     * The note
     */
    public String getNote() {
        return note;
    }

    /**
     *
     * @param note
     * The note
     */
    public void setNote(String note) {
        this.note = note;
    }

}