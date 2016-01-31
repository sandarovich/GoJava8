package com.sandarovich.kickstarter;

/**
 * @author Olexander Kolodiazhny 2016
 *
 */

public class KickStarter implements Runnable {
    
    public static final String APP_VERSION = "0.0.1";

    public void run() {
        Output output = new ConsoleOutput();
        new Intro(output, APP_VERSION).run();
    }

}
