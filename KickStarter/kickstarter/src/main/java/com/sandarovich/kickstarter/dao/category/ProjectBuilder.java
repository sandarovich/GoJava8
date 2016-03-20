package com.sandarovich.kickstarter.dao.category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created Olexander Kolodiazhny 2016
 */

public class ProjectBuilder {

    private List<Project> projects;
    private Project project;
    // Required fields
    private int id;
    //    private Category category;
    private String name;

    // Optional fields
    private String shortDescription = "<<Empty>>";
    private double requiredBudget = 1000d;
    private double gatheredBudget = 0d;
    private int daysLeft = 7;
    private String videoLink = "https://www.google.com";
    private String history = "No history";
    private String questionsAnswers = "No Q&A";


    public ProjectBuilder() {
        this.projects = new ArrayList<Project>();
    }


    public ProjectBuilder forId(int id) {
        this.id = id;
        return this;
    }


    public ProjectBuilder andName(String name) {
        this.name = name;
        return this;
    }

    public ProjectBuilder andDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public ProjectBuilder andRequiredBudget(double requiredBudget) {
        this.requiredBudget = requiredBudget;
        return this;
    }


    public ProjectBuilder build() {
        this.project = new Project(id, name, shortDescription,
            requiredBudget, gatheredBudget, daysLeft, videoLink,
            history, questionsAnswers);
        this.add();
        return this;
    }

    private ProjectBuilder add() {
        projects.add(this.project);
        return this;
    }


    public List<Project> getProjects() {
        return this.projects;
    }

//    public ProjectBuilder add(int id, Category category, String name, String shortDesription,
//                              double goalAmount, double collectedAmount, Calendar goalDate, String videoLink,
//                              String history, String questionsAnswers) {
//        this.id = id;
//        this.category = category;
//        this.name = name;
//        this.shortDescription = shortDesription;
//        this.goalAmount = goalAmount;
//        this.collectedAmount = collectedAmount;
//        this.goalDate = goalDate;
//        this.videoLink = videoLink;
//        this.history = history;
//        this.questionsAnswers = questionsAnswers;
//        this.add();
//        return this;
//    }


}
