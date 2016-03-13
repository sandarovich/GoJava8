package com.sandarovich.kickstarter;

/**
 * Quota Dao interface
 */

public interface QuotaDao {
    String getQuota(int quotaIndex);
    String getRandomQuota();
}
