package com.sandarovich.kickstarter.controller;

import com.sandarovich.kickstarter.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class CategoriesController {
    private static final String CATEGORIES = "categories";

    @Autowired
    CategoryDao categoryDao;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String showCategories(Map<String, Object> model) {
        model.put("title", "Categories");
        model.put(CATEGORIES, categoryDao.getAll());
        return CATEGORIES;
    }
}
