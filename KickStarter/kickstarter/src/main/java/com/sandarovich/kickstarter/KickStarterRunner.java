package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.io.ConsoleIO;
import com.sandarovich.kickstarter.io.IO;
import com.sandarovich.kickstarter.project.ApplicationMode;

import java.io.IOException;

/**
 *  Kick starter starting tool
 */

public class KickStarterRunner {
    public static void main(String[] args) {
        IO console = new ConsoleIO();
        ConfigReader configReader = new ConfigReader();
        ApplicationMode mode;
        try {
            mode = configReader.getMode(configReader.readConfig("config.properties"));
        } catch (IOException e) {
            console.write(e.getMessage());
            console.write("<<Fix>> Failover plan is taking place.");
            mode = ApplicationMode.MEMORY;

        }
        console.write(">> Application is running in : " + mode.toString() + " mode");
        new KickStarterNew(console).run();
    }
}
