package com.sandarovich.kickstarter.dao.quota;

import com.sandarovich.kickstarter.ConnectionManager;

/**
 * Quata Dao for Db
 */

public class QuotaDaoDbImpl implements QuotaDao {

    private ConnectionManager connectionManager;

    public QuotaDaoDbImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
    @Override
    public Quota getRandomQuota() {

        return null;
    }
}
