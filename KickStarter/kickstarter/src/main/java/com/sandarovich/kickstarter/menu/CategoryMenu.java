package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.category.CategorySource;
import com.sandarovich.kickstarter.io.IO;
import com.sandarovich.kickstarter.project.ProjectSource;

/**
 * @author Olexander Kolodiazhny 2016
 */

public class CategoryMenu extends AbstractMenu {

    public CategoryMenu(IO console, CategorySource categories, ProjectSource projects) {
        super(console, categories, projects);
        menuId = 1;
        headerLabel = "Сategories:";
        menuElements = new MenuElement[categories.size() + 1];
        for (int index = 0; index < categories.size(); index++) {
            menuElements[index + MENU_SHIFT] = new MenuElement(categories.get(index).toString()
                    , Actions.SHOW_CATEGORY, categories.get(index).getId() + MENU_SHIFT);
        }
        menuElements[0] = new MenuElement("Exit", Actions.EXIT, 0);

    }

    @Override
    public void performAction(int choice) {
        Actions action = getAction(choice);
        if (action != null && action == Actions.EXIT) {
            showMainMenu();
        }

        if (action != null && action == Actions.SHOW_CATEGORY) {
            showProjectsMenu(choice);
        }
    }


}
