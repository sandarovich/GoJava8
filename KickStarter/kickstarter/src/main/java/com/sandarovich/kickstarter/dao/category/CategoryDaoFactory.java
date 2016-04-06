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
        if (DaoMode.MEMORY == mode) {
            return new CategoryDaoMemoryImpl();
        }

        if (DaoMode.FILE == mode) {
            return new CategoryDaoFileImpl();
        }

        if (DaoMode.DB == mode) {
            return new CategoryDaoDbImpl();
        }

        return null;
    }
}
