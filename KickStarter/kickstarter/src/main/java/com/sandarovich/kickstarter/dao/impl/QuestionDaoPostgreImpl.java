package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.QuestionDao;
import com.sandarovich.kickstarter.model.Project;
import com.sandarovich.kickstarter.model.Question;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class QuestionDaoPostgreImpl implements QuestionDao {

    @Override
    public List<Question> getQuestions(Project project) {

//        return project.getQuestions();
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public void addQuestion(Question question) {
//        Session session = sessionFactory.getCurrentSession();
//        session.save(question);
//        session.flush();
    }
}
