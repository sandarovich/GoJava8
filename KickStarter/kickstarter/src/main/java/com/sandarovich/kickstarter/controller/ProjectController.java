package com.sandarovich.kickstarter.controller;

import com.sandarovich.kickstarter.dao.ProjectDao;
import com.sandarovich.kickstarter.dao.QuestionDao;
import com.sandarovich.kickstarter.model.Category;
import com.sandarovich.kickstarter.model.Project;
import com.sandarovich.kickstarter.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class ProjectController {

    private static final String PROJECT = "project";
    private static final String SC_NOT_FOUND = "404";

    @Autowired
    ProjectDao projectDao;
    @Autowired
    QuestionDao questionDao;

    @RequestMapping(value = "/" + PROJECT + "/{id}", method = RequestMethod.GET)
    public String showProject(@PathVariable Integer id, Map<String, Object> model) {
        if (!projectDao.isProjectExist(id)) {
            return SC_NOT_FOUND;
        }
        Project project = projectDao.findById(id);
        List<Question> questions;
        questions = questionDao.getQuestions(project);
        Category category = project.getCategory();
        model.put("title", project.getName());
        model.put(PROJECT, project);
        model.put("questions", questions);
        model.put("category", category);
        return PROJECT;
    }


}
