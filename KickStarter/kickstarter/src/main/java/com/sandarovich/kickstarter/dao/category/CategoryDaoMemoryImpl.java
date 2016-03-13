package com.sandarovich.kickstarter.dao.category;

import java.util.ArrayList;
import java.util.List;

/**
 * Category Dao Memory Implementation
 */
public class CategoryDaoMemoryImpl implements CategoryDao {

    private final List<Category> categories = new ArrayList<Category>();

    public CategoryDaoMemoryImpl() {
        fillCategories();
    }

    public void add(Category category) {
        categories.add(category);
    }

    void fillCategories() {
        add(new Category(1, "IT"));
        add(new Category(2, "Tourism"));
        add(new Category(3, "Garden"));
    }


    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public Category findCategoryById(int categoryId) {
        for (Category category : categories) {
            if (category.getId() == categoryId) {
                return category;
            }
        }
        return null;
    }

    @Override
    public boolean isValidCategory(String category) {
        int categoryId = 0;
        try {
            categoryId = Integer.parseInt(category);
        } catch (Exception e) {
            return false;
        }
        return findCategoryById(categoryId) != null;
    }

}
