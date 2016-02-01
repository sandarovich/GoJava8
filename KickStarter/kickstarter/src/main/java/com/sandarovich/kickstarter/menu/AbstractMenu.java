package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.IO;

/**
 * @author Olexander Kolodiazhny 2016 Describes common stuff for all menu
 */

public abstract class AbstractMenu {

    public AbstractMenu(IO console) {
        this.console = console;
    }

    protected MenuElement[] menuElements;
    protected String headerLabel;
    protected int menuId;
    protected IO console;

    public void show() {
        console.write("-----------");
        console.write("{" + menuId + "} " + headerLabel);
        console.write("-----------");
        if (menuElements.length < 1) {
            console.write("<< Is empty >>");
            return;
        }
        for (int index = 0; index < menuElements.length; index++) {
            console.write(menuElements[index].toString());
        }
        console.write("---");
    }

    public int readUserFeedback() {
        String result = console.read();
        if (isValidMenuElement(result)) {
            return Integer.parseInt(result);
        } else {
            console.write(">> Option is not found. Please try again");
            return readUserFeedback();
        }
    }

    private boolean isValidMenuElement(String checkedNumber) {
        int number = -1;
        try {
            number = Integer.parseInt(checkedNumber);
        } catch (NumberFormatException e) {
            return false;
        }

        return isValidMenuElement(number);
    }

    protected boolean isValidMenuElement(int number) {
        boolean result = true;
        if (number < 0 || number > menuElements.length - 1) {
            return false;
        }
        return result;
    }

    public abstract void doAction(int choise);

}
