package com.sandarovich.kickstarter.dao;

import com.sandarovich.kickstarter.model.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> getAll();

    Category findById(long categoeyId);

    boolean isCategoryExist(long categoryId);

}
