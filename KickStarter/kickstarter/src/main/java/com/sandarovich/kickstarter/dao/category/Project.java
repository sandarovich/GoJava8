package com.sandarovich.kickstarter.dao.category;

/**
 * Created by Olexander Koldoiazhnhy 2016
 */

public class Project {
    private static final long MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;
    private final int id;
    private final String name;
    private final String shortDesription;
    private final double requiredBudget;
    private final double collectedAmount;
    private final int daysLeft;
    private final String videoLink;
    private final String history;
    private final String questionsAnswers;

    public Project(int id, String name, String shortDesription,
                   double requiredBudget, double collectedAmount, int daysLeft, String videoLink,
                   String history, String questionsAnswers) {
        this.id = id;
        this.name = name;
        this.shortDesription = shortDesription;
        this.requiredBudget = requiredBudget;
        this.collectedAmount = collectedAmount;
        this.daysLeft = daysLeft;
        this.videoLink = videoLink;
        this.history = history;
        this.questionsAnswers = questionsAnswers;
    }

    public String getShortDescription() {
        return this.shortDesription;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRequiredBudget() {
        return requiredBudget;
    }

    public double getCollectedAmount() {
        return collectedAmount;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public String getHistory() {
        return history;
    }

    public String getQuestionsAnswers() {
        return questionsAnswers;
    }

    @Override
    public String toString() {
        return id + " -> " + name;
    }


}
