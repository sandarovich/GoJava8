package com.sandarovich.kickstarter.domain;

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
    private List<Question> questions = new ArrayList<Question>();
    private double gatherdBudget;
    private List<Award> awards = new ArrayList<Award>();

    public Project(int id, String name, String shortDesription,
                   double requiredBudget, double gatherdBudget, int daysLeft, String videoLink,
                   String history, List<Question> questions, List<Award> awards) {
        this.id = id;
        this.name = name;
        this.shortDesription = shortDesription;
        this.requiredBudget = requiredBudget;
        this.gatherdBudget = gatherdBudget;
        this.daysLeft = daysLeft;
        this.videoLink = videoLink;
        this.history = history;
        this.questions = questions;
        this.awards = awards;
    }


    @Override
    public String toString() {
        return id + " -> " +
            name;
    }

    public List<Object> getProjectAsObjectArray() {
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
        result.append("Questions: " + "\n");
        for (Question question : questions) {
            result.append(question.getText() + "\n");
        }
        result.append("History: " + history);
        return result.toString();
    }

    public void invest(double amount) {
        gatherdBudget += amount;
    }

    public void addQuestion(String question) {
        questions.add(new Question(question));
    }

    public List<Award> getAwards() {
        return awards;
    }


}
