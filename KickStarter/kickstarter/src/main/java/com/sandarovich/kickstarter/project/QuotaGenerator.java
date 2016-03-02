package com.sandarovich.kickstarter.project;

import java.util.ArrayList;
import java.util.List;

/**
 * Quata Generator.
 */

public class QuotaGenerator {
    private static final List<String> QUOATES;

    static {
        QUOATES = new ArrayList<String>();
        QUOATES.add("\"Every big journey begins with a small step\"");
        QUOATES.add("\"No pain, no gain\"");
    }

    public String getQuota() {
        return QUOATES.get(0);
    }
}
