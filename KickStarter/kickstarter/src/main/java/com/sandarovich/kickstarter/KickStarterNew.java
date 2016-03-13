package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.dao.category.Category;
import com.sandarovich.kickstarter.dao.category.CategoryDao;
import com.sandarovich.kickstarter.dao.quota.QuotaDao;
import com.sandarovich.kickstarter.io.IO;

/**
 * Console Kick Starter
 */

public class KickStarterNew {

    private IO io;
    private QuotaDao quotaDao;
    private CategoryDao categoryDao;


    public KickStarterNew(IO io, QuotaDao quotaDao, CategoryDao categoryDao) {
        this.io = io;
        this.quotaDao = quotaDao;
        this.categoryDao = categoryDao;
    }


    public void run() {
        showApplicationTitle();
        showQuota();
        showAllCategories();
        Category category = readCategory();
        showCategory(category);
    }

    private void showCategory(Category category) {
        io.write(category.toString());
    }

    private Category readCategory() {
        String readedCategory = io.read();

        if (!categoryDao.isValidCategory(readedCategory)) {
            io.write(">> Option is not found. Please try again");
            return readCategory();
        }
        return categoryDao.findCategoryById(Integer.parseInt(readedCategory));
    }


    private void showAllCategories() {
        for (Category category : categoryDao.getCategories()) {
            io.write(category.toString());
        }
    }

    private void showQuota() {
        io.write(quotaDao.getRandomQuota());
    }

    private void showApplicationTitle() {
        io.write(getApplicationTitle());
    }

    private String getApplicationTitle() {
        StringBuilder result = new StringBuilder();
        result.append("=======================================\n");
        result.append("     Kickstarter emulator\n");
        result.append("     by O.Kolodiazhny 2016\n");
        result.append("=======================================");
        return result.toString();
    }

}
