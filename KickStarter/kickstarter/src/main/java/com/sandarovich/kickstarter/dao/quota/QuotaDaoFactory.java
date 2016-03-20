package com.sandarovich.kickstarter.dao.quota;

import com.sandarovich.kickstarter.dao.category.DaoMode;

/**
 * Quota Dao Factory
 */
public class QuotaDaoFactory {

    public QuotaDao getQuotaDao(DaoMode mode) {
        if (DaoMode.MEMORY == mode) {
            return new QuotaDaoMemoryImpl();
        }
        if (DaoMode.FILE == mode) {
            return new QuotaDaoFileImpl();
        }
        if (DaoMode.DB == mode) {
            return new QuotaDaoDbImpl();
        }
        return null;
    }
}
