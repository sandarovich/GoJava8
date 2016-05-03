package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.CategoryDao;
import com.sandarovich.kickstarter.model.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CategoryDaoPostgeImpl implements CategoryDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Category> getAll() {
        return em.createNamedQuery("Category.getAll", Category.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Category findById(long categoryId) {
        Query query = em.createNamedQuery("Category.getById", Category.class);
        query.setParameter("id", categoryId);
        return (Category) query.getSingleResult();
    }
}
