package com.sandarovich.kickstarter.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    List<Payment> payments;
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryid")
    private Category category;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "required_budget")
    private double requiredBudget;
    @Column(name = "days_left")
    private int daysLeft;
    @Column(name = "video_link")
    private String videoLink;
    @Column(name = "history")
    private String history;

    public Project() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRequiredBudget() {
        return requiredBudget;
    }

    public void setRequiredBudget(double requiredBudget) {
        this.requiredBudget = requiredBudget;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getGatheredBudget() {
        double result = 0;
        for (Payment payment : payments) {
            result += payment.getAmount();
        }
        return result;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
