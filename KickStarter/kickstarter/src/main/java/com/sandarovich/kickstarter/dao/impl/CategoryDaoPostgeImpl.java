package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.CategoryDao;
import com.sandarovich.kickstarter.model.Category;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CategoryDaoPostgeImpl implements CategoryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Category> getCategories() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Category.class);
//        ProjectionList projectionList = Projections.projectionList();
//        projectionList.add(Projections.groupProperty("id"));
//        projectionList.add(Projections.groupProperty("name"));
//        criteria.setProjection(projectionList);
        return criteria.list();
    }

    @Transactional
    @Override
    public Category findById(long categoryId) {
        try (Session session = sessionFactory.getCurrentSession()) {
            return session.get(Category.class, categoryId);
        }
    }
}
