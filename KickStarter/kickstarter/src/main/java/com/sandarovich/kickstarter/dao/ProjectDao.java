package com.sandarovich.kickstarter.dao;


import com.sandarovich.kickstarter.domain.Category;
import com.sandarovich.kickstarter.domain.Project;

import java.util.List;

public interface ProjectDao {
    List<Project> getProjects(Category category);
    Project findProjectById(int projectId);
}
