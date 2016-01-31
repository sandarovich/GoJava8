package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.menu.MainMenu;
import com.sandarovich.kickstarter.menu.Menu;

/**
 * @author Olexander Kolodiazhny 2016
 *
 */

public class KickStarter {
    
    public static final String APP_VERSION = "0.0.1";
 
    public static void main(String[] args) {
        new KickStarter().start();
    }
    
    public void start() {
        Output output = new ConsoleOutput();
        
        new Intro(output, APP_VERSION).start();
        
        Menu menu = new MainMenu(output);
        menu.show();
    }

}
