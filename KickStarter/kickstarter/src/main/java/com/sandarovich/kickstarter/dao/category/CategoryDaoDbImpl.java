package com.sandarovich.kickstarter.dao.category;


import com.sandarovich.kickstarter.dao.DaoDB;
import com.sandarovich.kickstarter.dao.DaoException;
import com.sandarovich.kickstarter.dao.NoResultException;
import com.sandarovich.kickstarter.domain.Category;
import com.sandarovich.kickstarter.domain.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoDbImpl extends DaoDB implements CategoryDao {

    private static final String SQL_GET_CATEGORIES = "SELECT id, name FROM category";
    private static final String SQL_FIND_BY_CATEGORY = "SELECT id, name FROM category WHERE id=?";
    private static final java.lang.String SQL_FIND_PROJECTS_BY_CATEGORY =
        "SELECT id, name, description, required_budget, days_left, video_link, history" +
            "FROM project " +
            "WHERE categoryid=?;";

    @Override
    public List<Category> getCategories() {
        List<Category> result = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CATEGORIES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                result.add(category);
            }
            rs.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    public Category findCategoryById(int categoryId) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_CATEGORY)) {
            statement.setInt(1, categoryId);
            ResultSet rs = statement.executeQuery();
            Category category;
            if (rs.next()) {
                String name = rs.getString("name");
                rs.close();
                category = new Category();
                category.setId(categoryId);
                category.setName(name);
            } else {
                throw new NoResultException("No category found");
            }
            return category;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Project> getProjects(Category category) {
        List<Project> projects = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_PROJECTS_BY_CATEGORY)) {
            statement.setInt(1, category.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setName(rs.getString("name"));
                project.setDesription(rs.getString("description"));
                project.setRequiredBudget(rs.getDouble("required_budget"));
                project.setDaysLeft(rs.getInt("days_left"));
                project.setHistory(rs.getString("history"));
                project.setVideoLink(rs.getString("video_link"));
                projects.add(project);
            }
            rs.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return projects;
    }

}
