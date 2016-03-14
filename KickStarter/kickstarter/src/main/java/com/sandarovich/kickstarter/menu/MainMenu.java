package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.dao.category.CategoryDaoMemoryImpl;
import com.sandarovich.kickstarter.io.IO;

/**
 * @author Olexander Kolodiazhny 2016
 */

public class MainMenu extends AbstractMenu {

    public MainMenu(IO console, CategoryDaoMemoryImpl categories) {
        super(console, categories);
        menuId = 0;
        headerLabel = "Main Menu:";
        menuElements = new MenuElement[2];
        menuElements[1] = new MenuElement("All categories", Actions.SHOW_ALL_CATEGORIES, 1);
        menuElements[0] = new MenuElement("Exit", Actions.EXIT, 0);

    }

    @Override
    public void performAction(int choice) {
        Actions action = getAction(choice);

        if (action != null && action == Actions.EXIT) {
            console.write(">> Bye");
            return;
        }
        if (action != null && action == Actions.SHOW_ALL_CATEGORIES) {
            showCategoriesMenu();
        }
    }

}
