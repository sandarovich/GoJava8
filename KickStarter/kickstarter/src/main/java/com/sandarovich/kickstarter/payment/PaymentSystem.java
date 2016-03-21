package com.sandarovich.kickstarter.payment;

/**
 * PaymentSystem interface
 */

public interface PaymentSystem {
    boolean isPossible(double amount);

    boolean isProcess(double amount);
}
