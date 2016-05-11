package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.PaymentDao;
import com.sandarovich.kickstarter.dao.ProjectDao;
import com.sandarovich.kickstarter.dao.exception.NoResultException;
import com.sandarovich.kickstarter.model.Category;
import com.sandarovich.kickstarter.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private PaymentDao paymentDao;

    @Transactional(readOnly = true)
    @Override
    public Project findById(long projectId) {
        if (isProjectExist(projectId)) {
            Project project = em.find(Project.class, projectId);
            project.setGatheredBudget(paymentDao.getGatheredBudgetByProjectId(projectId));
            return project;
        } else {
            throw new NoResultException("Project not found");
        }
    }

    @Override
    public boolean isProjectExist(long projectId) {
        Query query = em.createNamedQuery("Project.isProjectExist");
        query.setParameter("id", projectId);
        long projectCount = (long) query.getSingleResult();
        return projectCount == 1;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Project> findByCategory(Category category) {
        Query query = em.createNamedQuery("Project.findByCategory");
        query.setParameter("category", category);
        List<Project> projects = query.getResultList();
        projects.forEach(project -> project.setGatheredBudget(paymentDao.getGatheredBudgetByProjectId(project.getId())));
        return projects;
    }


}
