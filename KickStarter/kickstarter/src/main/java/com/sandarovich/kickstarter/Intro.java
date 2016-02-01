package com.sandarovich.kickstarter;

/**
 * @author Olexander Kolodiazhny 2016
 *
 *         Show Application name, author and quote.
 */
public class Intro  {
    private IO console;
    private String appVersion;

    public Intro(IO output, String appVersion) {
        this.console = output;
        this.appVersion = appVersion;
    }

    public void show() {
        showAuthor();
        showQuote();
    }

    private void showAuthor() {
        console.write("=======================================");
        console.write("     Kickstarter emulator v." + appVersion);
        console.write("     by O.Kolodiazhny 2016      ");
        console.write("=======================================");
    }

    private void showQuote() {
        console.write("\"Every big journey begins with a small step\"\n");
    }

}
