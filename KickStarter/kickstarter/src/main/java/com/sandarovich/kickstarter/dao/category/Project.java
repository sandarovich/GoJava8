package com.sandarovich.kickstarter.dao.category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olexander Koldoiazhnhy 2016
 */

public class Project {
    private final int id;
    private final String name;
    private final String shortDesription;
    private final double requiredBudget;
    private final int daysLeft;
    private final String videoLink;
    private final String history;
    private String questionsAnswers;
    private double gatherdBudget;

    public Project(int id, String name, String shortDesription,
                   double requiredBudget, double gatherdBudget, int daysLeft, String videoLink,
                   String history, String questionsAnswers) {
        this.id = id;
        this.name = name;
        this.shortDesription = shortDesription;
        this.requiredBudget = requiredBudget;
        this.gatherdBudget = gatherdBudget;
        this.daysLeft = daysLeft;
        this.videoLink = videoLink;
        this.history = history;
        this.questionsAnswers = questionsAnswers;
    }


    @Override
    public String toString() {
        return id + " -> " +
            name;
    }

    public List<Object> getAsRow() {
        List<Object> result = new ArrayList<Object>();
        result.add(id);
        result.add(name);
        result.add(shortDesription);
        result.add(requiredBudget);
        result.add(gatherdBudget);
        result.add(daysLeft);
        return result;
    }


    public int getId() {
        return id;
    }

    public String getFullDetails() {
        StringBuilder result = new StringBuilder();
        result.append("Id: " + id + "\n");
        result.append("Name: " + name + "\n");
        result.append("Short Description: " + shortDesription + "\n");
        result.append("Required Budget: " + requiredBudget + "\n");
        result.append("Gathered Budget: " + gatherdBudget + "\n");
        result.append("Days Left: " + daysLeft + "\n");
        result.append("Video: " + videoLink + "\n");
        result.append("Questions: " + questionsAnswers + "\n");
        result.append(history);
        return result.toString();
    }

    public void invest(double ammount) {
        gatherdBudget += ammount;
    }

    public void addQuestion(String question) {
        questionsAnswers += question;
    }
}
