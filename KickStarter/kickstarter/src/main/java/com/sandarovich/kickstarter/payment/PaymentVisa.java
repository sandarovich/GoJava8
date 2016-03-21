package com.sandarovich.kickstarter.payment;

/**
 * PaymentVisa
 */
public class PaymentVisa implements Payment {
    private int id;
    private long cardNumber;
    private String cardHolder;
    private double amount;

    @Override
    public boolean isPossible() {
        //TODO implement Payment system check
        return true;
    }

    @Override
    public boolean isProcess(double amount) {
        if (isPossible() && amount > 0) {
            return true;
        }
        return false;
    }


}
