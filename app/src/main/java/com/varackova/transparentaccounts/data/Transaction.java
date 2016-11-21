package com.varackova.transparentaccounts.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Structure for transaction
 */
public class Transaction {

    @SerializedName("amount")
    @Expose
    private Amount amount;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("dueDate")
    @Expose
    private String dueDate;
    @SerializedName("processingDate")
    @Expose
    private String processingDate;
    @SerializedName("sender")
    @Expose
    private Sender sender;
    @SerializedName("receiver")
    @Expose
    private Receiver receiver;

    /**
     * @return The amount
     */
    public Amount getAmount() {
        return amount;
    }

    /**
     * @param amount The amount
     */
    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The dueDate
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate The dueDate
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return The processingDate
     */
    public String getProcessingDate() {
        return processingDate;
    }

    /**
     * @param processingDate The processingDate
     */
    public void setProcessingDate(String processingDate) {
        this.processingDate = processingDate;
    }

    /**
     * @return The sender
     */
    public Sender getSender() {
        return sender;
    }

    /**
     * @param sender The sender
     */
    public void setSender(Sender sender) {
        this.sender = sender;
    }

    /**
     * @return The receiver
     */
    public Receiver getReceiver() {
        return receiver;
    }

    /**
     * @param receiver The receiver
     */
    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

}