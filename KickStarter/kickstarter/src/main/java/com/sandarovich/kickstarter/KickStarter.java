package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.category.Categories;
import com.sandarovich.kickstarter.category.CategoriesBuilder;
import com.sandarovich.kickstarter.menu.AbstractMenu;
import com.sandarovich.kickstarter.menu.MainMenu;
import com.sandarovich.kickstarter.project.ProjectBuilder;
import com.sandarovich.kickstarter.project.Projects;

import java.util.ArrayList;
import java.util.List;

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
        new Intro(console).show();
        Categories categories = setupCategories();
        Projects projects = setupProjects(categories);
        AbstractMenu menu = new MainMenu(console, categories, projects);
        menu.show();
        menu.doAction(menu.readUserFeedback());

    }

    public Projects setupProjects(Categories categories) {
        ProjectBuilder builder = new ProjectBuilder();
        builder.forId(1)
                .andCategory(categories.get(0))
                .andName("USB TOY   ")
                .andDesription("Not Ordinary gameplay ")
                .build();
        builder.forId(2)
                .andCategory(categories.get(0))
                .andName("Power Bank")
                .andDesription("Unique technology ")
                .build();
        builder.forId(3)
                .andCategory(categories.get(0))
                .andName("Robot Frodo")
                .andDesription("Fast and Smart")
                .build();
        return builder.getProjects();
    }

    public Categories setupCategories() {
        final List<String> CATEGORIES = new ArrayList<String>() {{
            add("IT");
            add("Tourism");
            add("Garden");
        }};

        CategoriesBuilder builder = new CategoriesBuilder();
        builder.createAll(CATEGORIES);
        return builder.get();
    }
}
