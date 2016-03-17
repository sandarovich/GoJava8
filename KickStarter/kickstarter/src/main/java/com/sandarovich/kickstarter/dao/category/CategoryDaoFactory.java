package com.sandarovich.kickstarter.dao.category;

import com.sandarovich.kickstarter.DaoMode;

/**
 * Category Dao Factory
 */

public class CategoryDaoFactory {
    public CategoryDao getCategoryDao(DaoMode mode) {
        if (mode == null) {
            return null;
        }
        if (mode == DaoMode.MEMORY) {
            return new CategoryDaoMemoryImpl();
        }

        if (mode == DaoMode.FILE) {
            return new CategoryDaoFileImpl();
        }

        return null;
    }
}
