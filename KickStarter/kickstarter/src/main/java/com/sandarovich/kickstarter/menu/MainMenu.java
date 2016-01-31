package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.ConsoleOutput;
import com.sandarovich.kickstarter.Output;

/**
 * @author Olexander Kolodiazhny 2016
 *
 */

public class MainMenu extends AbstractMenu implements Menuable {

    private Output output;

    public MainMenu(Output output) {
        this.output = output;
        menuId = 1;
        headerLabel = "Main Menu:";
        menuElements = new MenuElement[2];
        menuElements[0] = new MenuElement("1 - Show categories");
        menuElements[1] = new MenuElement("2 - Exit");
    }

    @Override
    public void show() {
        output.print(headerLabel);
        for (int index = 0; index < menuElements.length; index++) {
            output.print(menuElements[index].toString());
        }
        
    }
    
    @Override
    public void exit() {
        System.exit(0); 
    }

}
