package com.sandarovich.kickstarter;

/**
 * Quota Dao Factory
 */
public class QuotaDaoFactory {

    public QuotaDao getQuotaDao(ApplicationMode mode) {
        if (mode == null) {
            return null;
        }
        if (mode == ApplicationMode.MEMORY) {
            return new QuotaDaoMemoryImpl();
        }
        return null;
    }
}
