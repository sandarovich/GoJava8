package com.sandarovich.kickstarter;

/**
 * Application Mode reader Test
 */

import com.sandarovich.kickstarter.project.ApplicationMode;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class ConfigReaderTest {

    private ConfigReader configReader;

    @Before
    public void init() {
        configReader = new ConfigReader();
    }

    @Test(expected = IOException.class)
    public void testNoPropertyFileExists() throws IOException {
        //when
        configReader.readConfig("configFake.properties");
    }

    @Test
    public void testEmptyProperty() throws IOException {
        //when
        Properties prop = null;
        assertEquals("Is empty property", configReader.getMode(prop), null);
    }

    @Test
    public void testMemoryModeProperty() throws IOException {
        //when
        Properties prop = new Properties();
        prop.setProperty("mode", "memory");
        assertEquals("memory mode", configReader.getMode(prop), ApplicationMode.MEMORY);
    }

    @Test
    public void testModePropertyExistButNotFound() throws IOException {

        //when
        Properties prop = new Properties();
        prop.setProperty("mode", "zzzzzzz");
        assertEquals("Not found mode", configReader.getMode(prop), ApplicationMode.MEMORY);
    }

    @Test
    public void testModePropertyFile() throws IOException {

        //when
        Properties prop = new Properties();
        prop.setProperty("mode", "file");
        assertEquals("File mode", configReader.getMode(prop), ApplicationMode.FILE);
    }

    @Test
    public void testModePropertyDB() throws IOException {
        //given
        ConfigReader amr = new ConfigReader();
        //when
        Properties prop = new Properties();
        prop.setProperty("mode", "db");
        assertEquals("DB mode", configReader.getMode(prop), ApplicationMode.DB);
    }

}

