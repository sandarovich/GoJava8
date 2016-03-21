package com.sandarovich.kickstarter.payment;

/**
 * Payment
 */

public class Payment {
    private int id;
    private double amount;
    private String cardHolder;
    private String cardNumber;

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        try {
            this.amount = Double.valueOf(amount);
        } catch (Exception e) {
            throw new NumberFormatException("Amount is incorrect");
        }
    }
}
