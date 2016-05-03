package com.sandarovich.kickstarter.dao.impl;

import com.sandarovich.kickstarter.dao.PaymentDao;
import com.sandarovich.kickstarter.model.Payment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PaymentDaoPostgreImpl implements PaymentDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void pay(Payment payment) {
//        Session session = sessionFactory.getCurrentSession();
//        session.save(payment);
//        session.flush();
    }
}
