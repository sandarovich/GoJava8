package com.sandarovich.kickstarter.category;

/**
 * Tests for Category Source
 */

import com.sandarovich.kickstarter.dao.category.Category;
import com.sandarovich.kickstarter.dao.category.CategoryDaoMemoryImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CategoryDaoMemoryImplTest {


    @Test
    public void testGetCategoryByIdNotFoundValue() {
        CategoryDaoMemoryImpl cs = new CategoryDaoMemoryImpl();
        assertNull(cs.findCategoryById(-1));
    }

    @Test
    public void testGetCategoryByIdValueExist() {
        CategoryDaoMemoryImpl cs = new CategoryDaoMemoryImpl();
        Category category = new Category(777, "IT");
        cs.add(category);
        cs.add(new Category(2, "Garden"));
        assertEquals(category, cs.findCategoryById(777));

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
        int size = 0;
        for (Category category : cs.getCategories()) {
            size++;
        }
        assertEquals(5, size);
    }


}

