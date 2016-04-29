package com.sandarovich.kickstarter.dao;


import com.sandarovich.kickstarter.model.Category;
import com.sandarovich.kickstarter.model.Project;
import com.sandarovich.kickstarter.model.Question;

import java.util.List;

public interface ProjectDao {
    List<Project> findByCategory(Category category);
    Project findById(long projectId);

    List<Question> getQuestions(Project project);

}
