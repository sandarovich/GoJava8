package com.sandarovich.kickstarter.dao.quota;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Quota Dao Memory.
 */

public class QuotaDaoMemoryImpl implements QuotaDao {

    protected List<Quota> quotas;

    public QuotaDaoMemoryImpl() {
        fillQuotas();
    }

    void fillQuotas() {
        quotas = new ArrayList<Quota>();
        quotas.add(new Quota("Mr SS", "Every big journey begins with a small step"));
        quotas.add(new Quota("Mr SS", "No pain, no gain"));
        quotas.add(new Quota("Mr SS", "Excellence across the board"));
    }

    Quota getQuotaById(int quotaIndex) {
        return (quotaIndex >= 0 && quotaIndex <= quotas.size()) ?
            quotas.get(quotaIndex) :
            quotas.get(0);
    }

    public Quota getRandomQuota() {
        int quotaIndex = new Random().nextInt(quotas.size());
        return getQuotaById(quotaIndex);
    }
}
