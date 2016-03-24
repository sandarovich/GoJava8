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
        String user = "kickstarter";
        String pass = "777";
        String dbName = "kickstarter";
        String host = "localhost";
        String url = "jdbc:postgresql://" + host + ":5432/" + dbName;
        connection = DriverManager.getConnection(url, user, pass);
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
