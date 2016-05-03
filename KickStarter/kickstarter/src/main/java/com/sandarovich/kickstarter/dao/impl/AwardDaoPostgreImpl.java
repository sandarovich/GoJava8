package com.sandarovich.kickstarter.dao.impl;

import com.sandarovich.kickstarter.dao.AwardDao;
import com.sandarovich.kickstarter.model.Award;
import com.sandarovich.kickstarter.model.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AwardDaoPostgreImpl implements AwardDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public List<Award> getByProject(Project project) {
        return null;
    }
}
