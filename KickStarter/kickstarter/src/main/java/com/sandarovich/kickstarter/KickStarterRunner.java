package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.dao.category.CategoryDao;
import com.sandarovich.kickstarter.dao.category.CategoryDaoFactory;
import com.sandarovich.kickstarter.dao.quota.QuotaDao;
import com.sandarovich.kickstarter.dao.quota.QuotaDaoFactory;
import com.sandarovich.kickstarter.io.ConsoleIO;
import com.sandarovich.kickstarter.io.IO;

import java.io.IOException;

/**
 * Kick starter starting tool
 */

public class KickStarterRunner {
    public static void main(String[] args) {
        IO io = new ConsoleIO();
        ApplicationMode mode = getApplicationMode(io);
        QuotaDao quotaDao = new QuotaDaoFactory().getQuotaDao(mode);
        CategoryDao categoryDao = new CategoryDaoFactory().getCategoryDao(mode);
        new KickStarterNew(io, quotaDao, categoryDao).run();
    }

    private static ApplicationMode getApplicationMode(IO console) {
        ConfigReader configReader = new ConfigReader();
        ApplicationMode mode;
        try {
            mode = configReader.getMode(configReader.readConfig("config.properties"));
        } catch (IOException e) {
            console.write(e.getMessage());
            console.write("<<Fix>> Failover plan is taking place.");
            mode = ApplicationMode.MEMORY;

        }
        console.write("=======================================");
        console.write(">> Application is running in : " + mode.toString() + " mode");
        return mode;
    }
}
