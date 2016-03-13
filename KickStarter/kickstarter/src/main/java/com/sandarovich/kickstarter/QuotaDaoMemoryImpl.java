package com.sandarovich.kickstarter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Quota Dao Memory.
 */

public class QuotaDaoMemoryImpl implements QuotaDao {

    private List<Quota> quotas;

    public void fillQuotas() {
        quotas = new ArrayList<Quota>();
        quotas.add(new Quota("Mr X", "Every big journey begins with a small step"));
        quotas.add(new Quota("Mr Y", "No pain, no gain"));
        quotas.add(new Quota("Mr Z", "Excellence across the board"));
    }

    public String getQuota(int quotaIndex) {
        return (quotaIndex >= 0 && quotaIndex <= quotas.size()) ?
                quotas.get(quotaIndex).toString() :
                quotas.get(0).toString();
    }

    public String getRandomQuota() {
        int quotaIndex = new Random().nextInt(quotas.size());
        return getQuota(quotaIndex);
    }
}