package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.ProjectDao;
import com.sandarovich.kickstarter.model.Category;
import com.sandarovich.kickstarter.model.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProjectDaoPostgreImpl implements ProjectDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public Project findById(long projectId) {
//        Session session = sessionFactory.getCurrentSession();
//        Project project = session.get(Project.class, projectId);
//        if (Objects.isNull(project)) {
//            throw new NoResultException("Project not found");
//        }
//        return project;
        return null;
    }


    @Transactional(readOnly = true)
    @Override
    public List<Project> findByCategory(Category category) {
//        Session session = sessionFactory.getCurrentSession();
//        Criteria criteria = session.createCriteria(Project.class);
//        criteria.add(Restrictions.eq("category", category));
//        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//        return criteria.list();
        return null;
    }


}
