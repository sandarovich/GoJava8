package com.sandarovich.kickstarter.io;

import com.sandarovich.kickstarter.dao.DaoMode;
import com.sandarovich.kickstarter.dao.category.CategoryDao;
import com.sandarovich.kickstarter.dao.quote.QuoteDao;
import com.sandarovich.kickstarter.domain.Category;
import com.sandarovich.kickstarter.domain.Project;
import com.sandarovich.kickstarter.domain.Quote;
import dnl.utils.text.table.TextTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Output\Read text to user console
 */

public class ConsoleIO implements IO {

    public static final String LONG_DIVIDER = "=======================================";
    public static final String OPTION_NOT_FOUND = ">> Option not found";

    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public String read() {
        String resultStr = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            resultStr = reader.readLine();
        } catch (IOException e) {
            System.out.println(">> Exception.Unable to read input");
        }
        return resultStr;
    }

    @Override
    public void writeProjectsAsTable(List<Project> object) {
        ProjectTableView projectTableView = new ProjectTableView(object);
        TextTable textTable = new TextTable(projectTableView.getColumnNames(), projectTableView.getData());
        textTable.printTable();
    }

    @Override
    public void writeCategory(Category category) {
        System.out.println(category.getId() + " -> " + category.getName());
    }

    @Override
    public void writeAllCategories(CategoryDao categoryDao) {
        for (Category category : categoryDao.getCategories()) {
            writeCategory(category);
        }
    }

    @Override
    public void writeViewTitle(String titleName) {
        System.out.println(LONG_DIVIDER);
        System.out.println(titleName);
        System.out.println(LONG_DIVIDER);
    }

    @Override
    public void writeApplicationTitle() {
        System.out.println(LONG_DIVIDER);
        System.out.println("    Kickstarter emulator");
        System.out.println("    by O.Kolodiazhny 2016");
        System.out.println(LONG_DIVIDER);
    }

    @Override
    public void writeQuote(QuoteDao quoteDao) {
        Quote quote = quoteDao.getRandomQuota();
        System.out.println(quote.getAuthor() + " : \"" + quote.getQuote() + "\"");
    }

    @Override
    public void writeDaoMode(DaoMode daoMode) {
        System.out.println(">> Application is running in : " + daoMode.name() + " mode");
    }

    @Override
    public Category readCategory(CategoryDao categoryDao, String value) {

        if (!categoryDao.isValidCategory(value)) {
            System.out.println(OPTION_NOT_FOUND);
            readCategory(categoryDao, read());
        }
        return categoryDao.findCategoryById(Integer.parseInt(value));
    }


}
