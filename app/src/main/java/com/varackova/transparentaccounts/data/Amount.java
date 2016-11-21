package com.varackova.transparentaccounts.data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

/**
 * Structure for transaction amount
 */
public class Amount {

    @SerializedName("value")
    @Expose
    private BigDecimal value;
    @SerializedName("precision")
    @Expose
    private Integer precision;
    @SerializedName("currency")
    @Expose
    private String currency;

    /**
     * @return The value
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * @param value The value
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * @return The precision
     */
    public Integer getPrecision() {
        return precision;
    }

    /**
     * @param precision The precision
     */
    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    /**
     * @return The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

