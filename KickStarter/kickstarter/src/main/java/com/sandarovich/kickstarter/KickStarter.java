package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.menu.AbstractMenu;
import com.sandarovich.kickstarter.menu.MainMenu;

/**
 * @author Olexander Kolodiazhny 2016
 *  KickStrter annalog.
 *  
 */

public class KickStarter {
    
    public static final String APP_VERSION = "0.0.4";
    
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
        menu.show();
        menu.doAction(menu.readUserFeedback());
        
    }

}
