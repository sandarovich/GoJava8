package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.ProjectDao;
import com.sandarovich.kickstarter.model.Category;
import com.sandarovich.kickstarter.model.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        Query query = em.createNamedQuery("Project.findByCategory");
        query.setParameter("category", category);
        return query.getResultList();
    }


}
