package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.ConsoleOutput;
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
        menuElements[0] = new MenuElement("Exit", 0);
        menuElements[1] = new MenuElement("Show categories", 1);
    }

    @Override
    public void show() {
        output.print("-----------");
        output.print(headerLabel);
        output.print("-----------");
        for (int index = 0; index < menuElements.length; index++) {
            output.print(menuElements[index].toString());
        }
        output.print("---");
    }

    @Override
    public void doAction(int choise) {
        
        if (choise == 0) {
            output.print(">> Bye");
            System.exit(0);
        } 
        
        if (choise == 1) {
            System.out.println(">> Categories");
        }
        
    }
    
}
