package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.Output;

/**
 * @author Olexander Kolodiazhny 2016 Describes common stuff for all menu
 */

public abstract class AbstractMenu {

    protected MenuElement[] menuElements;
    protected String headerLabel;
    protected int menuId;
    protected Output output;
    protected MenuReader menuReader;

    public int readUserFeedback() {
        int result = menuReader.read();
        return validateMenuElement(result);
    }

    private int validateMenuElement(int checkedNumber) {
        int result = checkedNumber;
        while (result < 0 || result > menuElements.length - 1) {
            output.print(">> Option is not found. Please try again");
            result = menuReader.read();
        }
        return result;
    }

    public abstract void show();
    public abstract void doAction(int choise);

}
