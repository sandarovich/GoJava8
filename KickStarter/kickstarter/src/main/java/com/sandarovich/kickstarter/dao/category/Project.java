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
    private final double gatherdBudget;
    private final int daysLeft;
    private final String videoLink;
    private final String history;
    private final String questionsAnswers;

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
                name + " " +
                shortDesription + " "
                + requiredBudget + " "
                + gatherdBudget + " "
                + daysLeft;
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




}
