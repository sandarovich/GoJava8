package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.dao.DaoMode;
import com.sandarovich.kickstarter.dao.category.*;
import com.sandarovich.kickstarter.dao.quote.QuoteDao;
import com.sandarovich.kickstarter.dao.quote.QuoteDaoFactory;
import com.sandarovich.kickstarter.io.IO;
import com.sandarovich.kickstarter.payment.Payment;
import com.sandarovich.kickstarter.payment.PaymentSystem;
import com.sandarovich.kickstarter.payment.PaymentVisa;

import java.util.List;

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
    public static final String BYE = ">> Bye!";
    public static final String SUCCESSFULLY_INVESTED = "Successfully invested.";
    public static final String AMOUNT_IS_INCORRECT = "Amount is incorrect. Operation aborted. Let's try again..";

    private IO io;
    private DaoMode daoMode;
    private QuoteDao quoteDao;
    private CategoryDao categoryDao;
    private Category category;
    private Project project;


    public KickStarter(IO io, DaoMode daoMode) {
        this.io = io;
        this.daoMode = daoMode;
        this.quoteDao = new QuoteDaoFactory().getQuotaDao(daoMode);
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
        readProjectOptions();
    }

    private void readProjectOptions() {
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
            readProjectOptions();
        }
    }

    private void showAskQuestion() {
        showViewTitle("Ask a question:");
        io.write("Please, enter you question: ");
        String question = io.read();
        project.addQuestion(question);
        showProjectsDetailsView();
    }

    private void showInvestView() {
        showViewTitle("Invest:");
        investIntoProject();
        showProjectsDetailsView();
    }


    private void investIntoProject() {
        Payment payment = readPaymentDetails();
        PaymentSystem paymentSystem = new PaymentVisa();
        if (paymentSystem.isPossible(payment.getAmount())
                && paymentSystem.isProcess(payment.getAmount())) {
            project.invest(payment.getAmount());
            io.write(SHORT_DIVIDER);
            io.write(payment.getAmount() + " $ " + SUCCESSFULLY_INVESTED);
            io.write(SHORT_DIVIDER);
        }

    }

    private Payment readPaymentDetails() {
        Payment result = new Payment();
        io.write("Please enter your name:");
        result.setCardHolder(io.read());
        io.write("Please enter your Card number:");
        result.setCardNumber(io.read());
        showAwardView();
        double amount = readPaymentAmount();
        result.setAmount(amount);
        return result;
    }

    private double readPaymentAmount() {
        String readedValue = io.read();

        if (EXIT_INPUT.equals(readedValue)) {
            try {
                io.write("Please enter amount:");
                return Double.valueOf(io.read());
            } catch (NumberFormatException e) {
                io.write(AMOUNT_IS_INCORRECT);
                showAwardView();
                return readPaymentAmount();
            }
        }
        int counter = 1;
        int currentOption = 0;
        try {
            currentOption = Integer.parseInt(readedValue);
        } catch (NumberFormatException e) {
            io.write(OPTION_NOT_FOUND);
            showAwardView();
            return readPaymentAmount();
        }
        for (Award award : project.getAwards()) {
            if (counter++ == currentOption) {
                return award.getAmount();
            }
        }
        io.write(OPTION_NOT_FOUND);
        return readPaymentAmount();
    }


    private void showAwardView() {
        showViewTitle("Award options:");
        int counter = 1;
        List<Award> awards = project.getAwards();
        for (Award award : awards) {
            io.write(String.valueOf(counter++) + " - " + award.getAward());
        }
        io.write(SHORT_DIVIDER);
        io.write("0" + " - Manually amount mode:");
    }


    private void exitKickstarter() {
        io.write(BYE);
        System.exit(0);
    }

    private void showProjectsView() {
        showViewTitle("<<Projects>> ");
        io.writeProjectsAsTable(category.getProjects());
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
        io.write(quoteDao.getRandomQuota().toString());
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
