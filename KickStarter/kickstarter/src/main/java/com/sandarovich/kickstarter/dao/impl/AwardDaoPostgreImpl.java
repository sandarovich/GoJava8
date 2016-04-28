package com.sandarovich.kickstarter.dao.impl;

import com.sandarovich.kickstarter.dao.AwardDao;
import com.sandarovich.kickstarter.model.Award;
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
public class AwardDaoPostgreImpl implements AwardDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Award> getByProject(Project project) {
        Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Award.class);
            criteria.add(Restrictions.eq("projectid", project.getId()));
            return criteria.list();
    }
}
