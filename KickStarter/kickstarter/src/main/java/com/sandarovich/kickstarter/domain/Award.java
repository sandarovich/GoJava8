package com.sandarovich.kickstarter.domain;

/**
 * Award
 */
public class Award {
    private int id;
    private double amount;
    private String description;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
