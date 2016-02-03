package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.Category;
import com.sandarovich.kickstarter.IO;
import com.sandarovich.kickstarter.Projects;

/**
 * @author Olexamder Kolodiazhny 2016
 */

//TODO Fix Project

public class ProjectMenu extends AbstractMenu {

    private Projects projects;

    public ProjectMenu(IO console, Projects projects) {
        super(console);
        this.projects = projects;
        menuId = 3;
        headerLabel = "Projects:";
        //projects = new Projects().getByCategory(category);
        int projectCount = projects.count();
        menuElements = new MenuElement[projectCount + 1];

        if (projectCount != 0) {
            for (int index = 0; index < projectCount; index++) {
                menuElements[index] = new MenuElement(projects.get(index).getShortDescription(), Actions.SHOW_PROJECT,
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
            for (int index = 0; index < projects.count(); index++) {
                console.write(index + "           " + projects.get(index).getDescription() + "        "
                        + projects.get(index).getShortDescription() + "        " + projects.get(index).getGoalAmount()
                        + "        " + projects.get(index).getcollectedAmount() + "        "
                        + projects.get(index).getGoalDateDays());
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
        // TODO Impement in Usere Case 4.

    }

}
