package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.category.Category;
import com.sandarovich.kickstarter.category.CategorySource;
import com.sandarovich.kickstarter.dao.quota.QuotaDao;
import com.sandarovich.kickstarter.io.IO;

/**
 * Console Kick Starter
 */

public class KickStarterNew {
    private IO io;
    private QuotaDao quotaDao;
    private CategorySource categorySource;


    public KickStarterNew(IO io, QuotaDao quotaDao) {
        this.io = io;
        this.quotaDao = quotaDao;
    }


    public void run() {
        configureDao();
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
        String readed = io.read();
        if (!categorySource.isValidCategory(readed)) {
            io.write(">> Option is not found. Please try again");
            return readCategory();
        }
        return categorySource.getCategoryById(Integer.parseInt(readed));
    }

    private void configureDao() {
        categorySource = new CategorySource();
        categorySource.init();
    }

    private void showAllCategories() {
        io.write(categorySource.getAllCategories());
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
