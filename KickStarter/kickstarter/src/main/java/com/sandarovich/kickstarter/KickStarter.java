package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.dao.category.*;
import com.sandarovich.kickstarter.dao.quota.QuotaDao;
import com.sandarovich.kickstarter.dao.quota.QuotaDaoFactory;
import com.sandarovich.kickstarter.io.IO;

/**
 * Console Kick Starter
 */

public class KickStarter {

    public static final String EXIT_INPUT = "0";
    public static final String CATEGORY_INPUT = "1";
    public static final String INVEST_INPUT = "2";
    public static final String ASK_QUESTION_INPUT = "3";
    public static final String OPTION_NOT_FOUND = ">> Option not found";
    public static final String SHORT_DIVIDER = "---";
    public static final String LONG_DIVIDER = "=======================================";

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
        if (EXIT_INPUT.equals(readedValue)) {
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
        readCategory();
        showСhosenCategory();
        showProjectsView();
        readProject();
    }

    private void showProjectsDetailsView() {
        showViewTitle("Project Details");
        io.write(project.getFullDetails());
        io.write(SHORT_DIVIDER);
        io.write(EXIT_INPUT + " - Projects");
        io.write(CATEGORY_INPUT + " - Category");
        io.write(INVEST_INPUT + " - Invest");
        io.write(ASK_QUESTION_INPUT + " - Ask a question");
        readProjectDetailsOptions();
    }

    private void readProjectDetailsOptions() {
        String readedValue = io.read();
        if (EXIT_INPUT.equals(readedValue)) {
            showProjectsView();
            readProject();
        } else if (CATEGORY_INPUT.equals(readedValue)) {
            showMainMenu();
        } else if (INVEST_INPUT.equals(readedValue)) {
            showInvestView();
        } else if (ASK_QUESTION_INPUT.equals(readedValue)) {
            showAskQuestion();
        } else {
            io.write(OPTION_NOT_FOUND);
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
    }

    private void showProjectsView() {
        showViewTitle("<<Projects>> ");
        io.writeProjectasTable(category.getProjects());
        io.write(SHORT_DIVIDER);
        for (Project project : category.getProjects()) {
            io.write(project.toString());
        }
        io.write(SHORT_DIVIDER);
        io.write(EXIT_INPUT + " -> Exit");
    }

    private void showDaoMode() {
        io.write(">> Application is running in : " + daoMode.toString() + " mode");
    }

    private void showСhosenCategory() {
        io.write(category.toString());
    }

    private void readCategory() {
        String readedValue = io.read();
        if (EXIT_INPUT.equals(readedValue)) {
            exitKickstarter();
        }
        if (!categoryDao.isValidCategory(readedValue)) {
            io.write(OPTION_NOT_FOUND);
            readCategory();
        }
        category = categoryDao.findCategoryById(Integer.parseInt(readedValue));
    }


    private void showCategoriesView() {
        showViewTitle("<<Category>> ");
        for (Category category : categoryDao.getCategories()) {
            io.write(category.toString());
        }
        io.write(SHORT_DIVIDER);
        io.write(EXIT_INPUT + " -> Exit");
    }

    private void showViewTitle(String titleName) {
        io.write(LONG_DIVIDER);
        io.write(titleName);
        io.write(LONG_DIVIDER);
    }

    void showQuota() {
        io.write(quotaDao.getRandomQuota().toString());
    }

    private void showApplicationTitle() {
        io.write(getApplicationTitle());
    }

    private String getApplicationTitle() {
        StringBuilder result = new StringBuilder();
        result.append(LONG_DIVIDER + "\n");
        result.append("     Kickstarter emulator\n");
        result.append("     by O.Kolodiazhny 2016\n");
        result.append(LONG_DIVIDER);
        return result.toString();
    }

}
