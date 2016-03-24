package com.sandarovich.kickstarter.dao.quote;

import com.sandarovich.kickstarter.ConnectionManager;
import com.sandarovich.kickstarter.domain.Quote;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Quata Dao for Db
 */

public class QuoteDaoDbImpl implements QuoteDao {

    private ConnectionManager connectionManager;

    public QuoteDaoDbImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public Quote getRandomQuota() {
        try (Statement statement = connectionManager.getConnection().createStatement()) {
            String query =
                    "SELECT " +
                            " \"QUOTE\".\"TEXT\"," +
                            "  \"QUOTA\".\"AUTHOR\"" +
                            "FROM " +
                            " public.\"QUOTA\"" +
                            "ORDER BY RANDOM() LIMIT(1)";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            return new Quote(rs.getString("AUTHOR"), rs.getString("TEXT"));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
