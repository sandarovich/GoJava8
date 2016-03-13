package com.sandarovich.kickstarter.dao.category;

import java.util.List;

/**
 * Category DAO
 */

public interface CategoryDao {
    List<Category> getCategories();

    Category getCategoryById(int id);
}
