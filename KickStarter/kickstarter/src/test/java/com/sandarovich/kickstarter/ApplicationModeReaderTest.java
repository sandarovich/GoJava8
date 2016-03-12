package com.sandarovich.kickstarter;

/**
 * Application Mode reader Test
 */

import org.junit.Test;

import java.io.IOException;

public class ApplicationModeReaderTest {

    @Test(expected = IOException.class)
    public void testNoPropertyFileExists() throws IOException {
        //given
        ApplicationModeReader amr = new ApplicationModeReader();
        //when
        amr.read("configFake.properties");
    }

}

