package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.IO;
import com.sandarovich.kickstarter.category.Categories;
import com.sandarovich.kickstarter.project.Projects;

/**
 * @author Olexander Kolodiazhny 2016
 *
 */

public class MainMenu extends AbstractMenu{

    public MainMenu(IO console, Categories categories, Projects projects) {
        super(console, categories, projects);
        menuId = 0;
        headerLabel = "Main Menu:";
        menuElements = new MenuElement[2];
        menuElements[1] = new MenuElement("Show categories", Actions.SHOW_ALL_CATEGORIES, 1);
        menuElements[0] = new MenuElement("Exit", Actions.EXIT, 0);
        
    }
 
    @Override
    public void doAction(int choice) {
        Actions action = menuElements[choice].getAction();
        
        if (action == Actions.EXIT) {
            console.write(">> Bye");
            return;
        } 
        
        if (action == Actions.SHOW_ALL_CATEGORIES) {
            AbstractMenu menu = new CategoryMenu(console, categories, projects);
            menu.show();
            menu.doAction(menu.readUserFeedback());
        }
        
    }
    
}
