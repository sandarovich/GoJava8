package com.sandarovich.kickstarter.payment;

/**
 * PaymentVisa
 */
public class PaymentVisa implements PaymentSystem {
    private int id;
    private long cardNumber;
    private String cardHolder;
    private double amount;

    @Override
    public boolean isPossible(double amount) {
        //TODO implement PaymentSystem system check
        return true;
    }

    @Override
    public boolean isProcess(double amount) {
        if (amount > 0 && isPossible(amount)) {
            return true;
        }
        return false;
    }


}
