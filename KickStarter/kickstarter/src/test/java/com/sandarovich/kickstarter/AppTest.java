package com.sandarovich.kickstarter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Olexander Kolodiazhny 2016
 *
 *  Simple tests
 *
 */

public class AppTest {

    private IO io = new ConsoleIO();
    ConsoleMock console = new ConsoleMock();

    @Test
    public void testMainMenu() {
        //given
        console.addIn("1");
        KickStarter kickStarter = new KickStarter(io);

        //when
        kickStarter.start();

        //then
        assertEquals("=======================================\n" +
                "     Kickstarter emulator v.0.0.5\n" +
                "     by O.Kolodiazhny 2016      \n" +
                "=======================================\n" +
                "\"Every big journey begins with a small step\"\n" +
                "\n" +
                "-----------\n" +
                "{0} Main Menu:\n" +
                "-----------\n" +
                "0 - Show categories\n" +
                "1 - Exit\n" +
                "---\n" +
                "1\n" +
                ">> Bye\n", console.getOut());

    }
}
