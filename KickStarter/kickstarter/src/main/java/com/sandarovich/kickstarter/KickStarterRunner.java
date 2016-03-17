package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.dao.category.DaoMode;
import com.sandarovich.kickstarter.io.ConsoleIO;
import com.sandarovich.kickstarter.io.IO;

/**
 * Kick starter starting tool
 */

public class KickStarterRunner {
    public static void main(String[] args) {
        IO io = new ConsoleIO();
        DaoMode daoMode = DaoMode.fromName(System.getProperty("mode"));
        new KickStarter(io, daoMode).run();
    }
}
