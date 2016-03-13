package com.sandarovich.kickstarter.category;

/**
 * Tests for Category Source
 */

import com.sandarovich.kickstarter.dao.category.Category;
import com.sandarovich.kickstarter.dao.category.CategoryDaoMemoryImpl;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CategoryDaoMemoryImplTest {

    @Test
    public void testGetAllCategories() {
        CategoryDaoMemoryImpl cs = new CategoryDaoMemoryImpl();
        cs.add(new Category(1, "IT"));
        cs.add(new Category(2, "Tourism"));

        assertThat("Get all Categories", cs.getAllCategories(),
                is("1 -> IT\n2 -> Tourism\n"));
    }


    @Test
    public void testGetCategoryByIdNotFoundValue() {
        CategoryDaoMemoryImpl cs = new CategoryDaoMemoryImpl();
        cs.fillCategories();
        assertNull(cs.getCategoryById(-1));
    }

    @Test
    public void testGetCategoryByIdValueExist() {
        CategoryDaoMemoryImpl cs = new CategoryDaoMemoryImpl();
        Category category = new Category(777, "IT");
        cs.add(category);
        cs.add(new Category(2, "Garden"));
        assertEquals(category, cs.getCategoryById(777));

    }

    @Test
    public void testIsValidCategoryValid() {
        CategoryDaoMemoryImpl cs = new CategoryDaoMemoryImpl();
        cs.add(new Category(1, "IT"));
        cs.add(new Category(2, "Tourism"));

        assertEquals(true, cs.isValidCategory("1"));
    }

    @Test
    public void testIsValidCategoryLetters() {
        CategoryDaoMemoryImpl cs = new CategoryDaoMemoryImpl();
        cs.add(new Category(1, "IT"));
        cs.add(new Category(2, "Tourism"));

        assertEquals(false, cs.isValidCategory("ZZZZ"));
    }

    @Test
    public void testIsValidCategoryNotValid() {
        CategoryDaoMemoryImpl cs = new CategoryDaoMemoryImpl();
        cs.add(new Category(1, "IT"));
        cs.add(new Category(2, "Tourism"));

        assertEquals(false, cs.isValidCategory("9"));
    }

    @Test
    public void testSize() {
        CategoryDaoMemoryImpl cs = new CategoryDaoMemoryImpl();
        cs.add(new Category(1, "IT"));
        cs.add(new Category(2, "Tourism"));

        assertEquals(2, cs.size());
    }


}

