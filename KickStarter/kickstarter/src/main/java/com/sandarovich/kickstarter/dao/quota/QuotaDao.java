package com.sandarovich.kickstarter.dao.quota;

/**
 * Quota Dao interface
 */

public interface QuotaDao {
    String getQuota(int quotaIndex);

    String getRandomQuota();
}
