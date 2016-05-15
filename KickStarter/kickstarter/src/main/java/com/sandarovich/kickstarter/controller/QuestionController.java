package com.sandarovich.kickstarter.controller;

import com.sandarovich.kickstarter.dao.ProjectDao;
import com.sandarovich.kickstarter.dao.QuestionDao;
import com.sandarovich.kickstarter.dto.QuestionDto;
import com.sandarovich.kickstarter.model.Project;
import com.sandarovich.kickstarter.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class QuestionController {
    private static final String QUESTION = "question";
    private static final String QUESTION_ADD_SUCCESS = "questionAddSuccess";
    private static final String QUESTION_ADD_UNSUCCESS = "questionAddUnSuccess";
    private static final String SC_NOT_FOUND = "404";

    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private ProjectDao projectDao;

    @RequestMapping(value = "/" + QUESTION + "/{projectId}", method = RequestMethod.GET)
    public String showQuestion(@PathVariable Integer projectId, Map<String, Object> model) {
        if (!projectDao.isProjectExist(projectId)) {
            return SC_NOT_FOUND;
        }
        Project project = projectDao.findById(projectId);
        model.put("title", "Question");
        model.put("project", project);
        QuestionDto questionForm = new QuestionDto();
        questionForm.setProjectId(project.getId());
        model.put("questionForm", questionForm);
        return QUESTION;
    }

    @RequestMapping(value = "/" + QUESTION + "/{projectId}", method = RequestMethod.POST)
    public String addQuestion(@ModelAttribute("questionForm") QuestionDto questionDto,
                              Map<String, Object> model) {
        Question question = new Question();
        question.setText(questionDto.getText());
        question.setProject(projectDao.findById(questionDto.getProjectId()));
        try {
            questionDao.addQuestion(question);
            model.put("question", questionDto);
            model.put("title", "Add Question Success");
            return QUESTION_ADD_SUCCESS;
        } catch (Exception e) {
            model.put("title", "Add Question was unsuccessfull!!");
            return QUESTION_ADD_UNSUCCESS;
        }

    }
}
