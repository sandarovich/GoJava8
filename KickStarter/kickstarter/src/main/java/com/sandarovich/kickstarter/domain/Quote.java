package com.sandarovich.kickstarter.domain;

/**
 * Quote
 */
public class Quote {

    private String author;
    private String quote;

    public Quote() {

    }

    public Quote(String author, String quote) {
        this.author = author;
        this.quote = quote;
    }

    public String getQuote() {
        return quote;
    }
    public String getAuthor() {
        return author;
    }
}
