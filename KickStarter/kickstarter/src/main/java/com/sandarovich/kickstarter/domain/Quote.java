package com.sandarovich.kickstarter.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Quote
 */
@JsonAutoDetect
public class Quote {

    private String author;
    private String quota;

    public Quote() {

    }

    public Quote(String author, String quota) {
        this.author = author;
        this.quota = quota;
    }

    @Override
    public String toString() {
        return author + ": " + "\"" + quota + "\"";
    }
    public String getQuote() {
        return quota;
    }
    public String getAuthor() {
        return author;
    }
}
