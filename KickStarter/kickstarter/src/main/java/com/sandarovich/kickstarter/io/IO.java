package com.sandarovich.kickstarter.io;

import com.sandarovich.kickstarter.dao.category.CategoryDao;
import com.sandarovich.kickstarter.domain.Category;
import com.sandarovich.kickstarter.domain.Project;

import java.util.List;

/**
 * @author Olexander Kolodiazhny 2016 
 * Describe common text output
 */

public interface IO {
    void write(String message);
    String read();

    void writeProjectsAsTable(List<Project> projects);
    void writeCategory(Category category);
    void writeAllCategories(CategoryDao categoryDao);

    void writeViewTitle(String titleName);

    void writeApplicationTitle();
}
