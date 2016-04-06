package com.sandarovich.kickstarter.dao.quote;

import com.sandarovich.kickstarter.dao.DaoException;
import com.sandarovich.kickstarter.dao.NoResultException;
import com.sandarovich.kickstarter.domain.Quote;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Quate Dao for Db
 */

public class QuoteDaoDbImpl implements QuoteDao {

    public static final String SQL_GET_RANDOM_QUOTE = "SELECT text, author " +
        "FROM " +
        "public.quote " +
        "ORDER BY RANDOM() LIMIT(1);";

    private DataSource dataSource;

    public QuoteDaoDbImpl() {
        initDataSource();
    }

    public void initDataSource() {
        try {
            Class.forName("org.postgresql.Driver");
            InitialContext initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/kickstarter");
        } catch (ClassNotFoundException | NamingException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Quote getRandomQuota() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_GET_RANDOM_QUOTE);
            if (!rs.next()) {
                throw new NoResultException("No records found in Quote table.");
            }
            return new Quote(rs.getString("AUTHOR"), rs.getString("TEXT"));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}

