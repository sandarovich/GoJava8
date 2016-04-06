package com.sandarovich.kickstarter.dao.quote;

import com.sandarovich.kickstarter.ConnectionManager;
import com.sandarovich.kickstarter.domain.Quote;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Quate Dao for Db
 */

public class QuoteDaoDbImpl implements QuoteDao {

    public static final String SQL_GET_RANDOM_QUOTE = "SELECT text, author " +
        "FROM " +
        "public.quote " +
        "ORDER BY RANDOM() LIMIT(1);";

    private ConnectionManager connectionManager;

    public QuoteDaoDbImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public Quote getRandomQuota() {
        try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(SQL_GET_RANDOM_QUOTE)) {
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
                throw new NoResultException("No records found in Quote table.");
            }
            Quote result = new Quote(rs.getString("AUTHOR"), rs.getString("TEXT"));
            return result;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
