package com.sandarovich.module1.helloworld;


/**
 * @author Olexander Kolodiazhny 2016
 * 
 * Output to console
 *
 */
public class SimpleConsoleOutput implements OutputFormatter {

    public void outputMessage(String message) {
	System.out.print(message);	
    }

}
