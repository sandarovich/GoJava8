package com.sandarovich.kickstarter;

import java.util.Calendar;

/**
 * Created by Olexander Koldoiazhnhy 2016
 */

public class Project {

    private final int id;
    private final Category category;
    private final String description;
    private final String shortDesription;
    private final double goalAmount;
    private final double collectedAmount;
    private final Calendar goalDate;
    private final String videoLink;
    private final String history;
    private final String questionsAnswers;

    public Project(int id, Category category, String description, String shortDesription,
                   double goalAmount, double collectedAmount, Calendar goalDate, String videoLink,
                   String history, String questionsAnswers) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.shortDesription = shortDesription;
        this.goalAmount = goalAmount;
        this.collectedAmount = collectedAmount;
        this.goalDate = goalDate;
        this.videoLink = videoLink;
        this.history = history;
        this.questionsAnswers = questionsAnswers;
    }

    public Category getCategory() {
        return this.category;
    }

    public String getShortDescription() {
        return this.shortDesription;
    }

    public String getDescription() {
        return description;
    }

    public double getGoalAmount() {
        return goalAmount;
    }

    public double getcollectedAmount() {
        return collectedAmount;
    }

    public int getGoalDateDays() {
        final long MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;
        int result;
        Calendar now = Calendar.getInstance();
        result = (int) ((goalDate.getTimeInMillis() - now.getTimeInMillis()) / MILLISECONDS_IN_DAY);
        return result;
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



}
