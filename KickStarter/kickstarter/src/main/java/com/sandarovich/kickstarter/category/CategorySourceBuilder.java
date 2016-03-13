package com.sandarovich.kickstarter.category;

import com.sandarovich.kickstarter.dao.category.Category;
import com.sandarovich.kickstarter.dao.category.CategoryDaoMemoryImpl;

import java.util.List;

/**
 * @author Olexander Kolodiazhny 2016
 */
public class CategorySourceBuilder {

    private final CategoryDaoMemoryImpl categories;
    private int id;
    private String name;

    public CategorySourceBuilder() {
        this.categories = new CategoryDaoMemoryImpl();
    }

    public CategorySourceBuilder forInt(int id) {
        this.id = id;
        return this;
    }

    public CategorySourceBuilder andName(String name) {
        this.name = name;
        return this;
    }

    public CategorySourceBuilder build() {
        categories.add(new Category(id, name));
        return this;
    }

    public void createAll(List<String> categories) {
        for (int index = 0; index < categories.size(); index++) {
            this.categories.add(new Category(index, categories.get(index)));
        }

    }

    public CategoryDaoMemoryImpl get() {
        return this.categories;
    }
}
