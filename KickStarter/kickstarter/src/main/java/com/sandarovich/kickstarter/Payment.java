package com.sandarovich.kickstarter;

/**
 * Payment interface
 */

public interface Payment {
    boolean isPossible();

    void process();
}
