package com.sandarovich.kickstarter;

import java.util.ArrayList;
import java.util.List;

/**
 * Olexander Kolodiazhny 2016
 */

public class Projects {
    private List<Project> projectsList = new ArrayList<Project>();

    public void add(Project project) {
        projectsList.add(project);
    }

    public void getByCategory(Category category) {
        ArrayList<Project> result = new ArrayList<Project>();

        for (int index = 0; index < projectsList.size(); index++)
            if (projectsList.get(index).getCategory() == category) {
                result.add(projectsList.get(index));
            }
    }

    public int count() {
        return this.projectsList.size();
    }

    public Project get(int index) {
        return projectsList.get(index);
    }


}
