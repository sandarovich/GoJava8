package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.IO;
import com.sandarovich.kickstarter.category.Categories;
import com.sandarovich.kickstarter.project.Projects;

/**
 * @author Olexander Kolodiazhny 2016
 */

public class CategoryMenu extends AbstractMenu {

    public CategoryMenu(IO console, Categories categories, Projects projects) {
        super(console, categories, projects);
        menuId = 1;
        headerLabel = "Сategories:";
        menuElements = new MenuElement[categories.size()];
        menuElements[0] = new MenuElement("Exit", Actions.EXIT, 0);
        for (int index = 0; index < categories.size() - 1; index++) {
            menuElements[index + MENU_SHIFT] = new MenuElement(categories.get(index).toString()
                    , Actions.SHOW_CATEGORY, index + MENU_SHIFT);
        }
    }

    @Override
    public void doAction(int choice) {
        if (isValidMenuElement(choice)) {
            Actions action = menuElements[choice].getAction();
            if (action == Actions.EXIT) {
                AbstractMenu menu = new MainMenu(console, categories, projects);
                menu.show();
                menu.doAction(menu.readUserFeedback());
            }

            if (action == Actions.SHOW_CATEGORY) {
                console.write(">> " + menuElements[choice].toString());
                AbstractMenu menu = new ProjectMenu(console, this.categories,
                        this.projects.getByCategory(this.categories.get(choice - MENU_SHIFT)));

                menu.show();
                console.write(">> Bye");
            }
        }

    }

}
