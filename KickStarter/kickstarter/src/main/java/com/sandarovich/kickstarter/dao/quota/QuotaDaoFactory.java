package com.sandarovich.kickstarter.dao.quota;

import com.sandarovich.kickstarter.ApplicationMode;

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

        if (mode == ApplicationMode.FILE) {
            return new QuotaDaoFileImpl();
        }

        return null;
    }
}
