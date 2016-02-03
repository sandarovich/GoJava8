package com.sandarovich.kickstarter.category;

/**
 * @author Olexander Kolodiazhny
 */

public class Category {

    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
