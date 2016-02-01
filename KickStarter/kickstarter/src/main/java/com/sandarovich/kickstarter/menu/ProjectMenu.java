package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.Category;
import com.sandarovich.kickstarter.IO;
import com.sandarovich.kickstarter.Project;
import com.sandarovich.kickstarter.ProjectsDB;

/**
 * @author Olexamder Kolodiazhny 2016
 *
 */

public class ProjectMenu extends AbstractMenu {

    private Project[] projects;

    public ProjectMenu(IO console, Category category) {
        super(console);
        menuId = 3;
        headerLabel = "Projects:";
        projects = new ProjectsDB().getByCategory(category);
        int projectCount = projects.length;
        menuElements = new MenuElement[projectCount + 1];

        if (projectCount != 0) {
            for (int index = 0; index < projects.length; index++) {
                menuElements[index] = new MenuElement(projects[index].getShortDescription(), Actions.SHOW_PROJECT,
                        index);
            }
        }

        menuElements[projectCount] = new MenuElement("Exit", Actions.EXIT, projectCount);

    }

    @Override
    public void show() {
        console.write("-----------");
        console.write("{" + menuId + "} " + headerLabel);
        console.write("------------------------------------------------------------------------------------");
        console.write("Project | Description | ShortDescription | Goal Amount| Collected Amount| Days Remain ");
        console.write("------------------------------------------------------------------------------------");
        if (menuElements.length > 1) {
            for (int index = 0; index < projects.length; index++) {
                console.write(index + "           " + projects[index].getDescription() + "        "
                        + projects[index].getShortDescription() + "        " + projects[index].getGoalAmount()
                        + "        " + projects[index].getcollectedAmount() + "        "
                        + projects[index].getGoalDateDays());
            }

        } else {
            console.write("<< Is empty >>");
        }
        console.write("---");
        console.write(menuElements[menuElements.length - 1].toString());
        console.write("---");

    }

    @Override
    public void doAction(int choise) {
        // TODO IMPLEMENT IN USERCASE 4

    }

}
