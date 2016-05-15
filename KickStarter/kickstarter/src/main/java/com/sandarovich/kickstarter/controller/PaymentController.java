package com.sandarovich.kickstarter.controller;

import com.sandarovich.kickstarter.dao.AwardDao;
import com.sandarovich.kickstarter.dao.ProjectDao;
import com.sandarovich.kickstarter.dto.PaymentDto;
import com.sandarovich.kickstarter.model.Award;
import com.sandarovich.kickstarter.model.Project;
import com.sandarovich.kickstarter.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class PaymentController {
    private static final String PAYMENT = "payment";
    private static final String SC_NOT_FOUND = "404";
    private static final String PROJECT = "project";

    @Autowired
    ProjectDao projectDao;

    @Autowired
    AwardDao awardDao;

    @RequestMapping(value = "/" + PAYMENT + "/{projectId}", method = RequestMethod.GET)
    public String showPayment(@PathVariable Integer projectId, Map<String, Object> model) {
        if (!projectDao.isProjectExist(projectId)) {
            return SC_NOT_FOUND;
        }
        Project project = projectDao.findById(projectId);
        List<Award> awards = awardDao.getByProject(project);
        model.put("title", "Payment");
        model.put("project", project);
        model.put("awards", awards);
        PaymentDto paymentForm = new PaymentDto();
        paymentForm.setProjectId(project.getId());
        model.put("paymentForm", paymentForm);
        return PAYMENT;
    }

    //TODO Implement functionality to store payment Award Id
    @RequestMapping(value = "/" + PAYMENT + "/{projectId}", method = RequestMethod.POST)
    ModelAndView addPayment(@PathVariable Integer projectId,
                            @ModelAttribute("paymentForm") PaymentDto paymentDto) {
        ModelAndView mav = new ModelAndView("redirect:/" + PROJECT + "/" + projectId);
        PaymentService paymentService = new PaymentService();
        paymentService.setPaymentDto(paymentDto);

        if (paymentService.allowPayment()) {
            mav.setViewName("paymentAddSuccess");
            mav.addObject("title", "Payment Success");
            mav.addObject("projectId", projectId);
        }

        return mav;
    }
}
