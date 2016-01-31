package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.ConsoleOutput;
import com.sandarovich.kickstarter.Output;

/**
 * @author Olexander Kolodiazhny 2016
 *
 */

public class MainMenu implements Menu {
    
    private Output output;
    
    public MainMenu(Output output) {
        this.output = output;
    }
    @Override
    public void show() {
        output.print("Main Menu:");
        
    }
    
}
