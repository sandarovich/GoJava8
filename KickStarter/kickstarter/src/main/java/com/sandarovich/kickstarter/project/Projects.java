package com.sandarovich.kickstarter.project;

import com.sandarovich.kickstarter.category.Category;

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

    public Projects getByCategory(Category category) {
        ArrayList<Project> result = new ArrayList<Project>();

        for (Project project : projectsList)
            if (project.getCategory() == category) {
                result.add(project);
            }
        this.projectsList = result;
        return this;
    }

    public int count() {
        return this.projectsList.size();
    }

    public Project get(int index) {
        return projectsList.get(index);
    }

    public List<Project> getAll() {
        return projectsList;
    }

    public Object[] getAsObjectBrief(int index) {
        final int COLUMN_COUNT = 6;
        Object[] result = new Object[COLUMN_COUNT];
        Project project = get(index);
        result[0] = project.getId();
        result[1] = project.getName();
        result[2] = project.getShortDescription();
        result[3] = project.getGoalAmount();
        result[4] = project.getcollectedAmount();
        result[5] = project.getGoalDateDays();
        return result;
    }

}
