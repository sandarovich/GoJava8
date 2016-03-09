package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.io.IO;

/**
 * Console Kick Starter
 */
public class KickStarterConsole {
    private IO console;
    private QuotaSource quotaSource;

    KickStarterConsole(IO console) {
        this.console = console;
    }

    public void start() {
        init();
        showApplicationTitle();
        showQuota();
    }


    private void init() {
        quotaSource = new QuotaSource();
        quotaSource.init();
    }

    private void showQuota() {
        console.write(quotaSource.getRandomQuota());
    }

    private void showApplicationTitle() {
        console.write(getApplicationTitle());
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
