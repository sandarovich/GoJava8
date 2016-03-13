package com.sandarovich.kickstarter.dao.quota;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Quota
 */
@JsonAutoDetect
public class Quota {

    private String author;
    private String quota;

    public Quota() {

    }

    public Quota(String author, String quota) {
        this.author = author;
        this.quota = quota;
    }

    @Override
    public String toString() {
        return author + ": " + "\"" + quota + "\"";
    }

    public String getQuota() {
        return quota;
    }

    public String getAuthor() {
        return author;
    }
}
