package com.sandarovich.kickstarter.dao.quota;

import com.sandarovich.kickstarter.ConnectionManager;
import com.sandarovich.kickstarter.dao.DaoMode;

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
            ConnectionManager connectionManager = new ConnectionManager();
            return new QuotaDaoDbImpl(connectionManager);
        }
        return null;
    }
}
