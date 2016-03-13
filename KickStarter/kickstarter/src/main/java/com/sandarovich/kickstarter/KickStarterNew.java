package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.dao.category.Category;
import com.sandarovich.kickstarter.dao.category.CategoryDao;
import com.sandarovich.kickstarter.dao.category.CategoryDaoMemoryImpl;
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
        if (!categoryDao.isValidCategory(readed)) {
            io.write(">> Option is not found. Please try again");
            return readCategory();
        }
        return categoryDao.getCategoryById(Integer.parseInt(readed));
    }

    private void configureDao() {
        categoryDao = new CategoryDaoMemoryImpl();
        categoryDao.fillCategories();
    }

    private void showAllCategories() {
        io.write(categoryDao.getAllCategories());
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
