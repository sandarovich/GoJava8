package com.sandarovich.kickstarter.dao.impl;

import com.sandarovich.kickstarter.dao.HibernateUtil;
import com.sandarovich.kickstarter.dao.QuoteDao;
import com.sandarovich.kickstarter.dao.exception.DaoException;
import com.sandarovich.kickstarter.model.Quote;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class QuoteDaoPostgreImpl implements QuoteDao {
    @Override
    public Quote getRandomQuota() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Quote quote;
        try (Session session = sessionFactory.openSession()) {
            int quoteCount = ((Long) session.createCriteria(Quote.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
            int randomQuoteIndex = new Random().nextInt(quoteCount) + 1;
            quote = session.get(Quote.class, randomQuoteIndex);
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
        return quote;
    }
}

