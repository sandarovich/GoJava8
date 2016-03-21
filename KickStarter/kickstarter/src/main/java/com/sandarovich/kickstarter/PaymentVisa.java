package com.sandarovich.kickstarter;

/**
 * PaymentVisa
 */
public class PaymentVisa implements Payment {
    private int id;
    private long cardNumber;
    private double amount;

    @Override
    public boolean isPossible() {
        return true;
    }

    @Override
    public void process() {

    }


}
