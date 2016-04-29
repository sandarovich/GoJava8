package com.sandarovich.kickstarter.dao;


import com.sandarovich.kickstarter.model.Question;

public interface QuestionDao {
    void addQuestion(Question question, int projectId);
}
