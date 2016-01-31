package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.menu.MainMenu;
import com.sandarovich.kickstarter.menu.Menuable;

/**
 * @author Olexander Kolodiazhny 2016
 *  KickStrter annalog.
 *  
 */

public class KickStarter {
    
    public static final String APP_VERSION = "0.0.1";
 
    public static void main(String[] args) {
        new KickStarter().start();
    }
    
    public void start() {
        Output output = new ConsoleOutput();
        
        new Intro(output, APP_VERSION).show();
        
        Menuable menu = new MainMenu(output);
        menu.show();
    }

}
