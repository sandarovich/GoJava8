package com.sandarovich.kickstarter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Olexander Kolodiazhny 2016
 *
 */

public class ConsoleReader implements Reader {

    @Override
    public int read() {
        String resultStr = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            resultStr = reader.readLine();
        }
        catch (IOException e) {
            new ConsoleOutput().print("Sorry.Unable to read");
        }
        
        return parse(resultStr);
    }

   private int parse(String inputStr) {
       int result = -1;
       try {
           result = Integer.parseInt(inputStr);
       } catch(Exception e) {
           new ConsoleOutput().print("Sorry. Numbers is allowed");
       }
       return result;     
   }
    
  
}
