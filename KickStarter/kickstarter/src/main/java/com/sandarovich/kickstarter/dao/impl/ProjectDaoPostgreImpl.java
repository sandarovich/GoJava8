package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.ProjectDao;
import com.sandarovich.kickstarter.model.Category;
import com.sandarovich.kickstarter.model.Project;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProjectDaoPostgreImpl implements ProjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    @Override
    public Project findById(long projectId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Project.class, projectId);
    }


    @Transactional(readOnly = true)
    @Override
    public List<Project> findByCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Project.class);
        criteria.add(Restrictions.eq("category", category));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }


}
