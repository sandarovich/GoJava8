package com.sandarovich.kickstarter.payment;

/**
 * Payment interface
 */

public interface Payment {
    boolean isPossible();

    boolean isProcess(double amount);
}
