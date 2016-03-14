package com.sandarovich.kickstarter.dao.category;

import java.util.ArrayList;
import java.util.List;

/**
 * Category Dao Memory Implementation
 */
public class CategoryDaoMemoryImpl implements CategoryDao {

    private final List<Category> categories = new ArrayList<Category>();

    public CategoryDaoMemoryImpl() {
        fillCategories();
    }

    public void add(Category category) {
        categories.add(category);
    }

    void fillCategories() {
        add(new Category(1, "IT", getITProjects()));
        add(new Category(2, "Tourism", getTourismProjects()));
        add(new Category(3, "Garden", getGardenProjects()));
    }

    private List<Project> getITProjects() {
        ProjectBuilder builder = new ProjectBuilder();
        builder.forId(101)
                .andName("USB TOY   ")
                .andDescription("Not Ordinary gameplay ")
                .build();
        builder.forId(102)
                .andName("Power Bank")
                .andDescription("Unique technology ")
                .build();
        builder.forId(3)
                .andName("Robot Frodo")
                .andDescription("Fast and Smart")
                .build();
        builder.forId(97);
        return builder.getProjects();
    }

    private List<Project> getTourismProjects() {
        ProjectBuilder builder = new ProjectBuilder();
        builder.forId(5)
                .andName("Super Bag")
                .andDescription("Auto resizable")
                .build();
        return builder.getProjects();
    }

    private List<Project> getGardenProjects() {
        ProjectBuilder builder = new ProjectBuilder();
        builder.forId(97)
                .andName("Bison grass")
                .andDescription("Power energy from sun")
                .build();
        builder.forId(77)
                .andName("Garfield grass")
                .andDescription("Feel exotic")
                .build();
        return builder.getProjects();
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public Category findCategoryById(int categoryId) {
        for (Category category : categories) {
            if (category.getId() == categoryId) {
                return category;
            }
        }
        return null;
    }

    @Override
    public boolean isValidCategory(String category) {
        int categoryId = 0;
        try {
            categoryId = Integer.parseInt(category);
        } catch (Exception e) {
            return false;
        }
        return findCategoryById(categoryId) != null;
    }

}
