package com.sandarovich.kickstarter.dao.quota;

import com.sandarovich.kickstarter.dao.category.DaoMode;

/**
 * Quota Dao Factory
 */
public class QuotaDaoFactory {

    public QuotaDao getQuotaDao(DaoMode mode) {
        if (mode == DaoMode.MEMORY) {
            return new QuotaDaoMemoryImpl();
        }

        if (mode == DaoMode.FILE) {
            return new QuotaDaoFileImpl();
        }

        if (mode == DaoMode.DB) {
            return new QuotaDaoDbImpl();
        }


        return null;
    }
}
