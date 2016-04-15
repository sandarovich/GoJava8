package com.sandarovich.kickstarter.dao;


import com.sandarovich.kickstarter.model.Category;
import com.sandarovich.kickstarter.model.Project;

import java.util.List;

public interface ProjectDao {
    List<Project> getByCategory(Category category);

    Project findById(int projectId);

}
