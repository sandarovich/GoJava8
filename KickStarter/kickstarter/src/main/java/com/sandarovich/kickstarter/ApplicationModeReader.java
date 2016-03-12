package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.project.ApplicationMode;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Reads Application mode from properties file
 */

public class ApplicationModeReader {

    public ApplicationMode read(String fileName) throws IOException {
        Properties prop = new Properties();
        InputStream input = null;

        input = getClass().getClassLoader().getResourceAsStream(fileName);
        try {
            if (input != null) {
                prop.load(input);
            } else {
                throw new FileNotFoundException("Property file " + fileName + " was not found");
            }
        } finally {
            try {
                input.close();
            } catch (Throwable e) {

            }
        }
        String mode = prop.getProperty("mode");

        if (mode.equals("memory")) {
            return ApplicationMode.MEMORY;
        }

        return null;
    }
}
