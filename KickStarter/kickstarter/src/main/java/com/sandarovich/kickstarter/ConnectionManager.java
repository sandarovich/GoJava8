package com.sandarovich.kickstarter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection manager
 */

public class ConnectionManager {

    private Connection connection;

    private void openConnection() throws SQLException {
        String url = "";
        connection = DriverManager.getConnection(url);
    }

    public synchronized Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            openConnection();
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
