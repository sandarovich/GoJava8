package com.sandarovich.kickstarter.dao.category;

import java.util.List;

/**
 * @author Olexander Kolodiazhny
 */

public class Category {

    private final int id;
    private final String name;
    private List<Project> projects;

    public Category(int id, String name, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return id + " -> " + name;
    }
}
