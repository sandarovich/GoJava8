package com.sandarovich.kickstarter.io;

import com.sandarovich.kickstarter.dao.category.Project;

import java.util.List;

/**
 * @author Olexander Kolodiazhny 2016 
 * Describe common text output
 */

public interface IO {
    void write(String message);
    String read();

    void writeProjectsAsTable(List<Project> projects);
}
