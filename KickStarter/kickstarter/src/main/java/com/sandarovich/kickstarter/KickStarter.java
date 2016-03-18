package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.dao.category.*;
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
    private Project project;


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
        project = category.findProjectById(readedValue);
        if (project == null) {
            io.write(">> Option not found");
            readProject();
        }
        showProjectsDetailsView();

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

    private void showProjectsDetailsView() {
        showViewTitle("Project Details");
        io.write(project.getFullDetails());
        io.write("---");
        io.write("0 - Projects");
        io.write("1 - Category");
        io.write("2 - Invest");
        io.write("3 - Ask a question");
        readProjectDetailsOptions();
    }

    private void readProjectDetailsOptions() {
        String readedValue = io.read();
        if (readedValue.equals("0")) {
            showProjectsView();
            readProject();
        } else if (readedValue.equals("1")) {
            showMainMenu();
        } else if (readedValue.equals("2")) {
            showInvestView();
        } else if (readedValue.equals("3")) {
            showAskQuestion();
        } else {
            io.write(">> Option not found");
            readProjectDetailsOptions();
        }
    }

    private void showAskQuestion() {
        showViewTitle("Ask a question:");
        io.write("You question: ");
        String question = io.read();
        project.addQuestion(question);

        showProjectsDetailsView();
    }

    private void showInvestView() {
        showViewTitle("Invest:");
        io.write("Please enter your name:");
        String name = io.read();
        io.write("Please enter your Card number:");
        String cardNumber = io.read();
        io.write("Please enter ammount:");
        String ammount = io.read();
        project.invest(Double.valueOf(ammount));

        showProjectsDetailsView();
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

    void showQuota() {
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
