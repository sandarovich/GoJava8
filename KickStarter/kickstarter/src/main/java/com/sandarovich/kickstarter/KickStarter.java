package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.menu.AbstractMenu;
import com.sandarovich.kickstarter.menu.MainMenu;

/**
 * @author Olexander Kolodiazhny 2016
 *         KickStarter analog.
 */

public class KickStarter {

    public static final String APP_VERSION = "0.0.5";

    private IO console;

    public KickStarter(IO console) {
        this.console = console;
    }

    public static void main(String[] args) {
        IO console = new ConsoleIO();
        new KickStarter(console).start();
    }

    public void start() {
        new Intro(console, APP_VERSION).show();
        AbstractMenu menu = new MainMenu(console);
        Projects projects = setupProjects().getProjects();
        menu.show();
        menu.doAction(menu.readUserFeedback());


    }

    public ProjectBuilder setupProjects() {
        ProjectBuilder builder = new ProjectBuilder();
        builder.forId(1)
                .andCategory(Category.IT)
                .andDescription("USB TOY")
                .makeProject()
                .add();
        return builder;
    }
}
