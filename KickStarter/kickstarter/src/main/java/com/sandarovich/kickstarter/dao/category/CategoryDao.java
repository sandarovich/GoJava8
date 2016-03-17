package com.sandarovich.kickstarter.dao.category;

import java.util.List;

/**
 * Category DAO
 */

public interface CategoryDao {
    List<Category> getCategories();
    Category findCategoryById(int id);
    boolean isValidCategory(String category);

}
