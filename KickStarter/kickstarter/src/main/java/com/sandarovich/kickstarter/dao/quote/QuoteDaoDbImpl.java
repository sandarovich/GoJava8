package com.sandarovich.kickstarter.dao.quote;

import com.sandarovich.kickstarter.dao.DaoException;
import com.sandarovich.kickstarter.dao.NoResultException;
import com.sandarovich.kickstarter.domain.Quote;

import javax.sql.DataSource;
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

    public QuoteDaoDbImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Quote getRandomQuota() {
        try (Statement statement = dataSource.getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_GET_RANDOM_QUOTE);
            if (!rs.next()) {
                throw new NoResultException("No records found in Quote table.");
            }
            Quote result = new Quote(rs.getString("AUTHOR"), rs.getString("TEXT"));
            rs.close();
            return result;
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }
}
