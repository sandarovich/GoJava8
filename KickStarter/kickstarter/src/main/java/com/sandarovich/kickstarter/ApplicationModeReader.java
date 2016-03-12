package com.sandarovich.kickstarter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Reads Application mode from properties file
 */

public class ApplicationModeReader {

    public void read(String fileName) throws IOException {
        Properties prop = new Properties();
        InputStream input = null;

        input = getClass().getClassLoader().getResourceAsStream(fileName);

        if (input != null) {
            prop.load(input);
        } else {
            throw new FileNotFoundException("Property file " + fileName + " was not found");
        }

    }
}
