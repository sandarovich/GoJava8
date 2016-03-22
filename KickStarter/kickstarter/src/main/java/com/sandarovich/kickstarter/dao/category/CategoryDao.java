package com.sandarovich.kickstarter.dao.category;

import com.sandarovich.kickstarter.domain.Category;

import java.util.List;

/**
 * Category DAO
 */

public interface CategoryDao {
    List<Category> getCategories();
    Category findCategoryById(int id);
    boolean isValidCategory(String category);

}
