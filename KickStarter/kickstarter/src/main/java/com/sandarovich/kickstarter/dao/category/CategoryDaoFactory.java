package com.sandarovich.kickstarter.dao.category;

import com.sandarovich.kickstarter.ApplicationMode;

/**
 * Category Dao Factory
 */

public class CategoryDaoFactory {
    public CategoryDao getCategoryDao(ApplicationMode mode) {
        if (mode == null) {
            return null;
        }
        if (mode == ApplicationMode.MEMORY) {
            return new CategoryDaoMemoryImpl();
        }

        if (mode == ApplicationMode.FILE) {
            return new CategoryDaoFileImpl();
        }

        return null;
    }
}
