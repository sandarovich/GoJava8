package com.sandarovich.kickstarter.dao.impl;

import com.sandarovich.kickstarter.dao.HibernateUtil;
import com.sandarovich.kickstarter.dao.QuoteDao;
import com.sandarovich.kickstarter.model.Quote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class QuoteDaoPostgreImpl implements QuoteDao {
    @Override
    public Quote getRandomQuota() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.get(Quote.class, 2);
    }


//    public static final String SQL_GET_RANDOM_QUOTE = "SELECT text, author " +
//        "FROM " +
//        "public.quote " +
//        "ORDER BY RANDOM() LIMIT(1);";
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//
//    @Override
//    public Quote getRandomQuota() {
//        Quote quote = jdbcTemplate.queryForObject(SQL_GET_RANDOM_QUOTE, new QuoteRowMapper());
//        return quote != null ? quote : new Quote("No Author", "No text");
//    }
//
//    private final class QuoteRowMapper implements RowMapper<Quote> {
//        public Quote mapRow(ResultSet rs, int rowNum) throws SQLException {
//            String author = rs.getString("author");
//            String text = rs.getString("text");
//            return new Quote(author, text);
//        }
//    }
}

