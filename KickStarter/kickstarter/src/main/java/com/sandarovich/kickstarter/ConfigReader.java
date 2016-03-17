package com.sandarovich.kickstarter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Reads Application mode from properties file
 */

public class ConfigReader {

    Properties readConfig(String fileName) throws IOException {
        Properties result = new Properties();
        InputStream input = null;

        input = getClass().getClassLoader().getResourceAsStream(fileName);
        try {
            if (input != null) {
                result.load(input);
                return result;
            } else {
                throw new FileNotFoundException("<<Err>> Property file: " + fileName + " was not found!!!");
            }
        } finally {
            try {
                input.close();
            } catch (Throwable e) {
            }
        }
    }

    public DaoMode getMode(Properties prop) {
        if (prop == null) {
            return null;
        }
        String value = prop.getProperty("mode");
        if (value.equals("file")) {
            return DaoMode.FILE;
        }
        if (value.equals("db")) {
            return DaoMode.DB;
        }

        return DaoMode.MEMORY;
    }
}
