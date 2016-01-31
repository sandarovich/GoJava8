package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.Output;

/**
 * @author Olexander Kolodiazhny 2016
 *
 */

public class MainMenu extends AbstractMenu{

    public MainMenu(Output output, MenuReader menuReader) {
        this.output = output;
        this.menuReader = menuReader;
        menuId = 0;
        headerLabel = "Main Menu:";
        menuElements = new MenuElement[2];
        menuElements[0] = new MenuElement("Show categories", Actions.SHOW_ALL_CATEGORIES, 1);
        menuElements[1] = new MenuElement("Exit", Actions.EXIT, 0);
        
    }
 
    @Override
    public void doAction(int choise) {
        Actions action = Actions.values()[choise];
        
        if (action == Actions.EXIT) {
            output.print(">> Bye");
            System.exit(0);
        } 
        
        if (action == Actions.SHOW_ALL_CATEGORIES) {
            AbstractMenu menu = new CategoryMenu(output, menuReader);
            menu.show();
            menu.doAction(menu.readUserFeedback());
        }
        
    }
    
}
