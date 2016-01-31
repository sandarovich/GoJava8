package com.sandarovich.kickstarter;

/**
 * @author Olexander Kolodiazhny 2016
 *
 */

public class KickStarter {
    
    public static final String APP_VERSION = "0.0.1";

    public void start() {
        Output output = new ConsoleOutput();
        new Intro(output, APP_VERSION).start();
    }

}
