package com.sandarovich.kickstarter.dao.quota;

import com.sandarovich.kickstarter.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Quata Dao for Db
 */

public class QuotaDaoDbImpl implements QuotaDao {

    private ConnectionManager connectionManager;

    public QuotaDaoDbImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
    @Override
    public Quota getRandomQuota() {
        try (Statement statement = connectionManager.getConnection().createStatement()) {
            String query =
                "SELECT " +
                    " \"QUOTA\".\"TEXT\"," +
                    "  \"QUOTA\".\"AUTHOR\"" +
                    "FROM " +
                    " public.\"QUOTA\"" +
                    "ORDER BY RANDOM() LIMIT(1)";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            return new Quota(rs.getString("AUTHOR"), rs.getString("TEXT"));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
