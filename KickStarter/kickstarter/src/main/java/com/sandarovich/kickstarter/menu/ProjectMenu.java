package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.ConsoleIO;
import com.sandarovich.kickstarter.IO;
import com.sandarovich.kickstarter.category.Categories;
import com.sandarovich.kickstarter.project.Project;
import com.sandarovich.kickstarter.project.Projects;
import dnl.utils.text.table.TextTable;

import java.io.PrintStream;
import java.util.Objects;

/**
 * @author Olexamder Kolodiazhny 2016
 */


public class ProjectMenu extends AbstractMenu {

    public ProjectMenu(IO console, Categories categories, Projects projects) {
        super(console, categories, projects);
        menuId = 3;
        headerLabel = "Projects:";
        int projectCount = projects.count();
        menuElements = new MenuElement[projects.count() + 1];

        if (projectCount != 0) {
            for (int index = 0; index < projectCount; index++) {
                menuElements[index + MENU_SHIFT] = new MenuElement(projects.get(index).toString(),
                        Actions.SHOW_PROJECT,
                        index + MENU_SHIFT);
            }

        }

        menuElements[0] = new MenuElement("Exit", Actions.EXIT, 0);

    }

    @Override
    public void show() {

        console.write("-----------");
        console.write("{" + menuId + "} " + headerLabel);

        if (menuElements.length < 1) {
            console.write("<< Is empty >>");
            return;
        }
        createProjectTable();
        console.write("---");
        console.write(menuElements[0].toString());
        console.write("---");

    }

    private void createProjectTable() {
        final int COLUMN_COUNT = 6;

        String[] columnNames = new String[COLUMN_COUNT];
        columnNames[0] = "Id";
        columnNames[1] = "Name";
        columnNames[2] = "Short Description";
        columnNames[3] = "Goal Ammount";
        columnNames[4] = "Collected Ammount";
        columnNames[5] = "Days remain";

        Object[][] data = new Object[projects.count()][COLUMN_COUNT];

        for (int index = 0; index < projects.count(); index++) {
            data[index] = projects.getAsObjectBrief(index);
        }
        if (console instanceof ConsoleIO) {
            TextTable tt = new TextTable(columnNames, data);
            tt.printTable();
        }
    }

    @Override
    public void doAction(int choise) {
        // TODO Impement in Usere Case 4.

    }

}
