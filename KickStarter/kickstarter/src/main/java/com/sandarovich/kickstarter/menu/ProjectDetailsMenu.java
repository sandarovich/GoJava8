package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.dao.category.CategoryDaoMemoryImpl;
import com.sandarovich.kickstarter.dao.category.Project;
import com.sandarovich.kickstarter.io.IO;

/**
 * Created Olexander Kolodiazhny 2016
 */

public class ProjectDetailsMenu extends AbstractMenu {

    private final Project project;

    public ProjectDetailsMenu(IO console, CategoryDaoMemoryImpl categories, Project project) {
        super(console, categories);
        this.project = project;
        menuId = 4;
        headerLabel = "Project Details:";
        menuElements = new MenuElement[2];
        menuElements[0] = new MenuElement("CategoryDaoMemoryImpl", Actions.SHOW_ALL_CATEGORIES, 0);
        menuElements[1] = new MenuElement("ProjectSource ", Actions.SHOW_CATEGORY, 1);
    }

    @Override
    public void show() {

        console.write("-----------");
        console.write("{" + menuId + "} " + headerLabel);
        console.write("-----------");
        console.write("Id: " + project.getId());
        console.write("Name: " + project.getName());
        console.write("Short Description: " + project.getShortDescription());
        console.write("Goal Amount: " + project.getRequiredBudget());
        console.write("Collected Amount: " + project.getCollectedAmount());
        console.write("Days remain: " + project.getDaysLeft());
        console.write("Video Link: " + project.getVideoLink());
        console.write("History: " + project.getHistory());
        console.write("Q&A: " + project.getQuestionsAnswers());

        console.write("---");
        console.write(menuElements[0].toString());
        console.write(menuElements[1].toString());
        console.write("---");
    }

    @Override
    public void performAction(int choice) {
        Actions action = getAction(choice);

        if (action != null && action == Actions.SHOW_ALL_CATEGORIES) {
            showCategoriesMenu();
        }

        if (action != null && action == Actions.SHOW_CATEGORY) {
//            showProjectsMenu(project.getCategory());
        }


    }


}
