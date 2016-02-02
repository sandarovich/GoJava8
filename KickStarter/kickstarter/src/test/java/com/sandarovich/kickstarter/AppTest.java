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

    @Test
    public void testGoToCategory() {
        //given
        console.addIn("0");
        console.addIn("4");
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
                "0\n" +
                "-----------\n" +
                "{1} Сategories:\n" +
                "-----------\n" +
                "0 - IT\n" +
                "1 - SOCIETY\n" +
                "2 - SPORT\n" +
                "3 - ECOLOGY\n" +
                "4 - Exit\n" +
                "---\n" +
                "4\n" +
                "-----------\n" +
                "{0} Main Menu:\n" +
                "-----------\n" +
                "0 - Show categories\n" +
                "1 - Exit\n" +
                "---\n" +
                "1\n" +
                ">> Bye\n", console.getOut());
    }

    @Test
    public void testToProjectMenu() {
        //given
        KickStarter kickStarter = new KickStarter(io);
        console.addIn("0");
        console.addIn("0");

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
                "0\n" +
                "-----------\n" +
                "{1} Сategories:\n" +
                "-----------\n" +
                "0 - IT\n" +
                "1 - SOCIETY\n" +
                "2 - SPORT\n" +
                "3 - ECOLOGY\n" +
                "4 - Exit\n" +
                "---\n" +
                "0\n" +
                ">> 0 - IT\n" +
                "IT\n" +
                "-----------\n" +
                "{3} Projects:\n" +
                "------------------------------------------------------------------------------------\n" +
                "Project | Description | ShortDescription | Goal Amount| Collected Amount| Days Remain \n" +
                "------------------------------------------------------------------------------------\n" +
                "0           USB Lighter           Lighter        7000.0        100.0        27\n" +
                "1           USB Toy & Joy         Toy             100.0        300.0        27\n" +
                "2           Smart Keyboard        Keyboard        700.0        200.0        27\n" +
                "---\n" +
                "3 - Exit\n" +
                "---\n" +
                ">> Bye\n", console.getOut());
    }

}
