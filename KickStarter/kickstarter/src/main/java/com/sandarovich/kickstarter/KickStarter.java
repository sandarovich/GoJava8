package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.dao.category.Category;
import com.sandarovich.kickstarter.dao.category.CategoryDao;
import com.sandarovich.kickstarter.dao.category.CategoryDaoFactory;
import com.sandarovich.kickstarter.dao.category.Project;
import com.sandarovich.kickstarter.dao.quota.QuotaDao;
import com.sandarovich.kickstarter.dao.quota.QuotaDaoFactory;
import com.sandarovich.kickstarter.io.IO;

/**
 * Console Kick Starter
 */

public class KickStarter {

    private IO io;
    private DaoMode daoMode;
    private QuotaDao quotaDao;
    private CategoryDao categoryDao;
    private Category category;


    public KickStarter(IO io, DaoMode daoMode) {
        this.io = io;
        this.daoMode = daoMode;
        this.quotaDao = new QuotaDaoFactory().getQuotaDao(daoMode);
        this.categoryDao = new CategoryDaoFactory().getCategoryDao(daoMode);
    }

    public void run() {
        showDaoMode();
        showMainMenu();
    }

    private void readProject() {
        String readedValue = io.read();
        if (readedValue.equals("0")) {
            showMainMenu();
        }
        Project project = category.findProjectById(readedValue);
        if (project == null) {
            io.write(">> Option not found");
            readProject();
        }
        showProjectsDetailsView(project);

    }

    private void showMainMenu() {
        showApplicationTitle();
        showQuota();
        showCategoriesView();
        category = readCategory();
        showСhosenCategory();
        showProjectsView();
        readProject();
    }

    private void showProjectsDetailsView(Project project) {
        showViewTitle("Project Details");
        io.write(project.getFullDetails());
        io.write("---");
        io.write("0 - Projects");
        io.write("1 - Category");
        readProjectDetailsOptions();
    }

    private void readProjectDetailsOptions() {
        String readedValue = io.read();
        if (readedValue.equals("0")) {
            showProjectsView();
            readProject();
        } else if (readedValue.equals("1")) {
            showMainMenu();
        } else {
            io.write(">> Option not found");
            readProjectDetailsOptions();
        }
    }

    private void exitKickstarter() {
        io.write(">> Bye!");
        System.exit(0);
    }

    private void showProjectsView() {
        showViewTitle("<<Projects>> ");
        io.writeProjectasTable(category.getProjects());
        io.write("---");
        for (Project project : category.getProjects()) {
            io.write(project.toString());
        }
        io.write("---");
        io.write("0 -> Exit");
    }

    private void showDaoMode() {
        io.write(">> Application is running in : " + daoMode.toString() + " mode");
    }

    private void showСhosenCategory() {
        io.write(category.toString());
    }

    private Category readCategory() {
        String readedValue = io.read();
        if (readedValue.equals("0")) {
            exitKickstarter();
        }
        if (!categoryDao.isValidCategory(readedValue)) {
            io.write(">> Option is not found. Please try again");
            return readCategory();
        }
        return categoryDao.findCategoryById(Integer.parseInt(readedValue));
    }


    private void showCategoriesView() {
        showViewTitle("<<Category>> ");
        for (Category category : categoryDao.getCategories()) {
            io.write(category.toString());
        }
        io.write("---");
        io.write("0 -> Exit");
    }

    private void showViewTitle(String titleName) {
        io.write("============");
        io.write(titleName);
        io.write("============");
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
